package vn.framgia.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import vn.framgia.bean.UserBean;
import vn.framgia.model.User;
import vn.framgia.service.IUserService;
import vn.framgia.social.UserDetail;

@Service
@EnableTransactionManagement
@Transactional
public class UserServiceImpl extends BaseserviceImpl implements IUserService {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	@Qualifier(value = "customUserDetailService")
	private UserDetailsService userDetailService;

	@Override
	@Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
	public UserDetail registerNewUser(UserBean userRegistrationForm) throws Exception {
		try {
			logger.info("--------------USER: " + userRegistrationForm.getFullName());
			User userExist = iUserDAO.getUser(userRegistrationForm.getUserId());
			if (userExist != null) {
				logger.info("--------------USER " + userExist.getFullName() + " EXITED");
				return (UserDetail) userDetailService.loadUserByUsername(userRegistrationForm.getUserId());
			}

			User user = buildUser(userRegistrationForm);
			iUserDAO.saveUser(user);

			return (UserDetail) userDetailService.loadUserByUsername(userRegistrationForm.getUserId());
		} catch (Exception e) {
			throw e;
		}
	}

	private User buildUser(UserBean formDTO) {
		User user = new User();
		user.setUserId(formDTO.getUserId());
		user.setEmail(formDTO.getEmail());
		user.setFullName(formDTO.getFullName());
		user.setPassword(formDTO.getPassword());
		user.setRole("ROLE_USER");
		user.setProvider(formDTO.getSocialProvider().name());
		return user;
	}
}
