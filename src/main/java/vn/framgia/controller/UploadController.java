package vn.framgia.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.ulti.Helpers;

@Controller
public class UploadController {
	private static final Logger logger = Logger.getLogger(UploadController.class);

	@Autowired
	private MessageSource amazonproperties;

	@Autowired
	private MessageSource messageSource;
	
	@RequestMapping(value="/upload")
	public ModelAndView redirectUpload(){
		return new ModelAndView("upload");
	}

	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
	public @ResponseBody String uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files,
			HttpServletRequest request) {

		if (files == null) {
			return messageSource.getMessage("missing_file", null, null);
		}
		String accessKey = amazonproperties.getMessage("AWSAccessKeyId", null, null);
		String secretKey = amazonproperties.getMessage("AWSSecretKey", null, null);
		String bucketName = amazonproperties.getMessage("bucketname", null, null);

		try {
			Helpers.upFileToAmozonS3(files, bucketName, accessKey, secretKey);
			logger.info("UPLOAD FILE SUCCESS");
		} catch (Exception e) {
			logger.info("FAILE UP LOAD FILE ", e);
			return messageSource.getMessage("fails_upload", null, null);
		}
		return messageSource.getMessage("success_upload", null, null);
	}

}
