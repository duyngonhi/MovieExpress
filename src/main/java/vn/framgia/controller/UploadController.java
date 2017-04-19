package vn.framgia.controller;

import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import vn.framgia.bean.FileBean;
import vn.framgia.model.FileS3;
import vn.framgia.service.IFileService;
import vn.framgia.ulti.Helpers;

@RestController
public class UploadController {
	private static final Logger logger = Logger.getLogger(UploadController.class);

	@Autowired
	private MessageSource amazonproperties;

	@Autowired
	private MessageSource messageSource;

	@Autowired
	private IFileService iFileService;

	@RequestMapping(value = "/upload")
	public ModelAndView redirectUpload() {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			List<FileBean> lstFileBeans = iFileService.findAllFile();
			if (Helpers.isEmpty(lstFileBeans)) {
				return new ModelAndView("upload", map);
			}
			map.put("lstFile", lstFileBeans);
		} catch (Exception e) {
			logger.info("ERROR GET ALL FILE: ", e);
		}
		return new ModelAndView("upload", map);
	}

	@RequestMapping(value = "/uploadMultiFile", method = RequestMethod.POST)
	public ModelAndView uploadMultipleFileHandler(@RequestParam("file") MultipartFile[] files,
			HttpServletRequest request) {
		Map<String, Object> map = new HashMap<String, Object>();
		try {
			System.out.println(files.length+" , "+files[0].getOriginalFilename());
			if (files[0].getOriginalFilename().isEmpty()) {
				map.put("message", messageSource.getMessage("uploadControll.missing_file", null, null));
				return redirectUpload().addAllObjects(map);
			}
			
			boolean boon = iFileService.saveFileToDb(files, amazonproperties.getMessage("bucketname", null, null));
			if(boon == true){
				map.put("message_save", messageSource.getMessage("uploadControll.save_file", null, null));
			}
			String accessKey = amazonproperties.getMessage("AWSAccessKeyId", null, null);
			String secretKey = amazonproperties.getMessage("AWSSecretKey", null, null);
			String bucketName = amazonproperties.getMessage("bucketname", null, null);
		
			Helpers.upFileToAmozonS3(files, bucketName, accessKey, secretKey);
			logger.info("UPLOAD FILE SUCCESS");
			map.put("message", messageSource.getMessage("uploadControll.success_upload", null, null));
			List<FileBean> lstFileBeans = iFileService.findAllFile();
			if (Helpers.isEmpty(lstFileBeans)) {
				return new ModelAndView("upload", map);
			}
			map.put("lstFile", lstFileBeans);
			
		} catch (Exception e) {
			logger.info("FAILE UP LOAD FILE ", e);
			map.put("message", messageSource.getMessage("uploadControll.fails_upload", null, null));
			return new ModelAndView("upload", map);
		}
		return new ModelAndView("upload", map);
	}
	
	@RequestMapping(value = "/download/{id}", method = RequestMethod.GET)
	public ModelAndView downLoadFile(@PathVariable("id") Integer id){
		Map<String, Object> map = new HashMap<String, Object>();
		URL url = null;
		try{
			if(id == null){
				return redirectUpload(); 
			}
			FileS3 fileS3 = iFileService.findById(id);
			if(fileS3 == null){
				return redirectUpload(); 
			}
			String accessKey = amazonproperties.getMessage("AWSAccessKeyId", null, null);
			String secretKey = amazonproperties.getMessage("AWSSecretKey", null, null);
			String bucketName = amazonproperties.getMessage("bucketname", null, null);
			
			url = Helpers.downloadFileS3(bucketName, accessKey, secretKey, fileS3.getNameFile());
			
		}catch(Exception e){
			logger.info("FAILE DOWNLOAD FILE ", e);
			return redirectUpload();
		}
		map.put("url", url);
		return new ModelAndView("upload", map);
	}

}
