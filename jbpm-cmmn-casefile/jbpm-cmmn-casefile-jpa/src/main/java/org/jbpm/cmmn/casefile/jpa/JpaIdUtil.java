package org.jbpm.cmmn.casefile.jpa;

import java.io.Serializable;
import java.lang.reflect.AnnotatedElement;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Id;

import org.jbpm.cmmn.casefile.common.AbstractIdUtil;

public class JpaIdUtil extends AbstractIdUtil<Serializable> {
	public static JpaIdUtil INSTANCE = new JpaIdUtil();

	@Override
	protected boolean isId(AnnotatedElement field) {
		return field.isAnnotationPresent(Id.class) || field.isAnnotationPresent(EmbeddedId.class);
	}

	@Override
	protected boolean isEntity(Class<?> commonSuperclass) {
		return commonSuperclass.isAnnotationPresent(Entity.class);
	}

}
