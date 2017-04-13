package vn.framgia.social;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.social.connect.UserProfile;

import vn.framgia.bean.SocialProvider;
import vn.framgia.bean.UserBean;
import vn.framgia.service.IUserService;
import vn.framgia.service.impl.UserServiceImpl;
import vn.framgia.ulti.SecurityUtil;

public class AppConnectionSignUp implements ConnectionSignUp {
	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);
	@Autowired
	private IUserService iUserService;

	@Override
	public String execute(Connection<?> connection) {
		try {
			logger.info("------------- CONNECT SINGN Up");
			UserBean userDetails = toUserRegistrationObject(connection.getKey().getProviderUserId(),
					SecurityUtil.toSocialProvider(connection.getKey().getProviderId()), connection.fetchUserProfile());
			UserDetail user = (UserDetail) iUserService.registerNewUser(userDetails);
			return user.getUserId();
		} catch (Exception e) {
			logger.info("ERROR EXECUTE CONNECT SINGN UP: ", e);
		}
		return null;
	}

	private UserBean toUserRegistrationObject(String userId, SocialProvider socialProvider,
			UserProfile userProfile) {
		return UserBean.getBuilder().addUserId(userId).addFullName(userProfile.getName())
				.addEmail(userProfile.getEmail()).addPassword(userProfile.getName()).addSocialProvider(socialProvider)
				.build();
	}

}
