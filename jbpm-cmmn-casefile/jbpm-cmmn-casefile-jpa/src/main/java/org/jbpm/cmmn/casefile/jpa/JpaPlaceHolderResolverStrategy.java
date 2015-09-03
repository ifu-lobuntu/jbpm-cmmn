package org.jbpm.cmmn.casefile.jpa;

import java.io.*;
import java.lang.reflect.Member;

import org.drools.core.common.DroolsObjectInputStream;
import org.kie.api.marshalling.ObjectMarshallingStrategy;
import org.kie.api.runtime.Environment;

import javax.persistence.EntityManager;

public class JpaPlaceHolderResolverStrategy implements ObjectMarshallingStrategy {
	private Environment env;

	public JpaPlaceHolderResolverStrategy(Environment env) {
		this.env = env;
	}

	public boolean accept(Object object) {
		try {
			JpaIdUtil.INSTANCE.findIdMember(object.getClass());
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public void write(ObjectOutputStream os, Object object) throws IOException {
		os.writeUTF(object.getClass().getCanonicalName());
		os.writeObject(getIdValue(object));
	}

	private Object getIdValue(Object object) {
		JpaCaseFilePersistence jop = (JpaCaseFilePersistence) env.get(JpaCaseFilePersistence.ENV_NAME);
		Member idMember = JpaIdUtil.INSTANCE.findIdMember(object.getClass());
		Serializable id = JpaIdUtil.INSTANCE.getId(idMember, object);
		EntityManager em = jop.getEntityManager();
		if(id == null) {
			em.persist(object);
			id = JpaIdUtil.INSTANCE.getId(idMember, object);
		} else {
			em.merge(object);
		}
		return id;
	}

	public Object read(ObjectInputStream is) throws IOException, ClassNotFoundException {
		String canonicalName = is.readUTF();
		Object id = is.readObject();
		JpaCaseFilePersistence jop = (JpaCaseFilePersistence) env.get(JpaCaseFilePersistence.ENV_NAME);
		return jop.find(Class.forName(canonicalName), id);
	}

	public byte[] marshal(Context context, ObjectOutputStream os, Object object) throws IOException {
		ByteArrayOutputStream buff = new ByteArrayOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(buff);
		oos.writeUTF(object.getClass().getCanonicalName());
		oos.writeObject(getIdValue(object));
		oos.close();
		return buff.toByteArray();
	}

	public Object unmarshal(Context context, ObjectInputStream ois, byte[] object, ClassLoader classloader) throws IOException, ClassNotFoundException {
		DroolsObjectInputStream is = new DroolsObjectInputStream(new ByteArrayInputStream(object), classloader);
		return read(is);
	}

	public Context createContext() {
		// no need for context
		return null;
	}

}
