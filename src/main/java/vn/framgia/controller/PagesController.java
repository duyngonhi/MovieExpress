package vn.framgia.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.ulti.Constant;
import vn.framgia.ulti.Helpers;

@RestController
public class PagesController {

	@Autowired
    MessageSource messageSource;
	
	@RequestMapping(value = Constant.URI_LOGIN, method = RequestMethod.GET)
	public ModelAndView login() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = Constant.URI_USERPAGE, method = RequestMethod.GET)
	public ModelAndView userPage() {
		ModelAndView model = new ModelAndView();
		model.addObject("user", Helpers.getUser());
		model.setViewName("index");
		return model;
	}

	@RequestMapping(value = Constant.URI_ACCESSDENIED, method = RequestMethod.GET)
	public ModelAndView accessDeniedPage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

}
