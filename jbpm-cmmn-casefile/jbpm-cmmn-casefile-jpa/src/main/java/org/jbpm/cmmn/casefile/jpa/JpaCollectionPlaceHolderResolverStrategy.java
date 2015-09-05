package org.jbpm.cmmn.casefile.jpa;

import java.beans.Introspector;
import java.io.*;
import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Member;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import javax.persistence.Query;

import org.drools.core.common.DroolsObjectInputStream;
import org.drools.persistence.TransactionAware;
import org.drools.persistence.TransactionManager;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;

public class JpaCollectionPlaceHolderResolverStrategy implements ObjectMarshallingStrategy,TransactionAware {
    private JpaCaseFilePersistence persistence;

    public JpaCollectionPlaceHolderResolverStrategy(JpaCaseFilePersistence persistence) {
        this.persistence = persistence;
    }

    @Override
    public boolean accept(Object object) {
        if (object instanceof Collection) {
            Collection<?> coll = (Collection<?>) object;
            if (coll.size() == 0) {
                return true;
            } else {
                Class<?> sc = findCommonSuperclass(coll);
                if (sc == null) {
                    return false;
                } else {
                    try {
                        JpaIdUtil.INSTANCE.findIdMember(sc);
                        return true;
                    } catch (Exception e) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    @Override
    public void write(ObjectOutputStream os, Object collection) throws IOException {
        if (collection instanceof Stack) {
            os.writeUTF(Stack.class.getName());
        } else if (collection instanceof List) {
            os.writeUTF(ArrayList.class.getName());
        } else if (collection instanceof Set) {
            os.writeUTF(HashSet.class.getName());
        } else {
            throw new IllegalArgumentException();
        }
        Collection<?> coll = (Collection<?>) collection;
        os.writeInt(coll.size());
        if (coll.size() > 0) {
            Class<?> commonSuperclass = findCommonSuperclass(coll);
            os.writeUTF(commonSuperclass.getName());
            Member idMember = JpaIdUtil.INSTANCE.findIdMember(commonSuperclass);
            ((AccessibleObject) idMember).setAccessible(true);
            String idName = idMember.getName();
            if (idMember instanceof Method) {
                idName = Introspector.decapitalize(idName.substring(3));
            }
            os.writeUTF(idName);
            for (Object object2 : coll) {
                Object id = getIdValue(object2);
                os.writeObject(id);
            }
        }
        persistence.getEntityManager().flush();
    }
    private Object getIdValue(Object object) {
        Member idMember = JpaIdUtil.INSTANCE.findIdMember(object.getClass());
        Serializable id = JpaIdUtil.INSTANCE.getId(idMember, object);
        if(id == null) {
            persistence.getEntityManager().persist(object);
            id = JpaIdUtil.INSTANCE.getId(idMember, object);
        } else {
            persistence.getEntityManager().merge(object);
        }
        return id;
    }
    public Class<?> findCommonSuperclass(Collection<?> c) {
        Iterator<?> iterator = c.iterator();
        Object next = iterator.next();
        Class<?> result = next.getClass();
        for (Object object : c) {
            while (!result.isInstance(object)) {
                result = result.getSuperclass();
            }
        }
        return result;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object read(ObjectInputStream is) throws IOException, ClassNotFoundException {
        String canonicalName = is.readUTF();
        Collection<Object> coll = null;
        try {
            coll = (Collection<Object>) Class.forName(canonicalName).newInstance();
        } catch (InstantiationException e) {
            throw new ClassNotFoundException(e.getMessage(), e);
        } catch (IllegalAccessException e) {
            throw new ClassNotFoundException(e.getMessage(), e);
        }
        int size = is.readInt();
        if (size > 0) {
            List<?> resultList = readCollection(is, size);
            coll.addAll(resultList);
        }
        return coll;
    }

    @SuppressWarnings("unused")
    private List<?> readCollectionOptimized(ObjectInputStream is, int size) throws ClassNotFoundException, IOException {
        String superClassName = is.readUTF();
        String idName = is.readUTF();
        Collection<Object> ids = new ArrayList<Object>();
        for (int i = 0; i < size; i++) {
            ids.add(is.readObject());
        }
        Query q = persistence.getEntityManager().createQuery("select o from " + superClassName + " o where o." + idName + " in (:ids)");
        q.setParameter("ids", ids);
        return q.getResultList();
    }

    private List<?> readCollection(ObjectInputStream is, int size) throws ClassNotFoundException, IOException {
        String superClassName = is.readUTF();
        @SuppressWarnings("unused")
        String idName = is.readUTF();
        List<Object> result = new ArrayList<Object>();
        for (int i = 0; i < size; i++) {
            result.add(persistence.find(superClassName, is.readObject()));
        }
        return result;
    }

    @Override
    public byte[] marshal(Context context, ObjectOutputStream os, Object object) throws IOException {
        ByteArrayOutputStream buff = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(buff);
        write(oos, object);
        oos.close();
        return buff.toByteArray();
    }

    @Override
    public Object unmarshal(Context context, ObjectInputStream ois, byte[] object, ClassLoader classloader) throws IOException, ClassNotFoundException {
        DroolsObjectInputStream is = new DroolsObjectInputStream(new ByteArrayInputStream(object), classloader);
        return read(is);
    }

    @Override
    public Context createContext() {
        // no need for context
        return null;
    }

    @Override
    public void onStart(TransactionManager txm) {
        persistence.start();
    }

    @Override
    public void onEnd(TransactionManager txm) {
        persistence.close();
    }
}
