package vn.framgia.service;

import java.io.Serializable;

import org.springframework.security.core.userdetails.UserDetails;

import vn.framgia.bean.UserBean;

public interface IUserService extends Serializable {
    public UserDetails registerNewUser(UserBean UserRegistrationForm) throws Exception;

}
