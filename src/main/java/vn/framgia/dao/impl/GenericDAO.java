package vn.framgia.dao.impl;

import org.hibernate.*;
import org.hibernate.criterion.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;
import java.io.Serializable;
import java.util.List;

/**
 * @author ducda referenced from CaveatEmptor project tm JBoss Hibernate version
 */
public abstract class GenericDAO<E, Id extends Serializable> extends HibernateDaoSupport {

	@Autowired
	public void anyMethodName(SessionFactory sessionFactory) {
		setSessionFactory(sessionFactory);
	}

	private Class<E> persistentClass;

	public Class<E> getPersistentClass() {
		return persistentClass;
	}

	public void setPersistentClass(Class<E> persistentClass) {
		this.persistentClass = persistentClass;
	}

	@SuppressWarnings("unchecked")
	public List<E> findAll() {
		DetachedCriteria criteria = DetachedCriteria.forClass(getPersistentClass());
		return (List<E>) getHibernateTemplate().findByCriteria(criteria);
	}

	@SuppressWarnings("unchecked")
	public E save(E entity) {
		getHibernateTemplate().saveOrUpdate(entity);
		getHibernateTemplate().flush();

		return entity;
	}

	public void delete(E entity) {
		getHibernateTemplate().delete(entity);
		getHibernateTemplate().flush();
	}
}
