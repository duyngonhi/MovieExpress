package vn.framgia.dao.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import vn.framgia.dao.IUserDAO;
import vn.framgia.model.User;

@Repository
public class UserDAOImpl extends GenericDAO<User, String> implements IUserDAO {

	@Autowired
	private HibernateTemplate hibernateTemplate;

	@Override
	public User getUser(String id) {
		return hibernateTemplate.get(User.class, id);
	}

	@Override
	public User saveUser(User object) {
		getHibernateTemplate().saveOrUpdate(object);
		getHibernateTemplate().flush();
		return object;
	}

}
