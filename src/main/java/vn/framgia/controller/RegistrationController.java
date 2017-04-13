package vn.framgia.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.UserBean;
import vn.framgia.service.IUserService;
import vn.framgia.social.UserDetail;
import vn.framgia.ulti.Constant;

@RestController
public class RegistrationController {
	private static final Logger logger = Logger.getLogger(RegistrationController.class);
	@Autowired
	private IUserService iUserService;
	
	@Autowired
    MessageSource messageSource;

	@RequestMapping(value = Constant.URI_USER_SIGNUP, method = RequestMethod.GET)
	public ModelAndView signup() {
		ModelAndView model = new ModelAndView();
		model.setViewName("registration");
		return model;
	}

	@RequestMapping(value = Constant.URI_USER_REGISTER, method = RequestMethod.POST)
	public @ResponseBody String registerUser(@RequestBody UserBean registrationForm) {
		try {
			if (registrationForm.getUserId() == null) {
				registrationForm.setUserId(registrationForm.getUserId());
			}
			UserDetail localUser = (UserDetail) iUserService.registerNewUser(registrationForm);
		} catch (Exception e) {
			logger.info("ERROR REGISTER USER: ", e);
			return messageSource.getMessage("registrationController.fails", null, null);
		}
		return messageSource.getMessage("registrationController.success", null, null);

	}
}
