package vn.framgia.dao;

import vn.framgia.model.User;

public interface IUserDAO extends IGenericDAO<User, String> {
    public User getUser(String id);
    public User saveUser(User user);
}
