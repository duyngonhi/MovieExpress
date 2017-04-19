package vn.framgia.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import vn.framgia.bean.FileBean;
import vn.framgia.model.FileS3;
import vn.framgia.service.IFileService;
import vn.framgia.ulti.Constant;
import vn.framgia.ulti.Helpers;

@Service
@EnableTransactionManagement
@Transactional
public class FileServiceImpl extends BaseserviceImpl implements IFileService {

	private static final Logger logger = Logger.getLogger(FileServiceImpl.class);

	@Override
	@Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
	public List<FileBean> findAllFile() throws Exception {
		List<FileBean> results = new ArrayList<FileBean>();
		try {
			List<FileS3> lstFile = iFileDAO.findAll();
			if (Helpers.isEmpty(lstFile)) {
				return null;
			}
			for (FileS3 file : lstFile) {
				results.add(new FileBean().setObFileBean(file));
			}
		} catch (Exception e) {
			logger.info("ERROR FINDALL FILE IN FileServiceImpl: ", e);
			throw e;
		}
		return results;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
	public boolean saveFileToDb(MultipartFile[] files, String bucketName) throws Exception {
		try {
			for (int i = 0; i < files.length; i++) {
				MultipartFile file = files[i];
				String nameFile = file.getOriginalFilename();
				FileS3 fileModel = new FileS3();
				fileModel.setNameFile(nameFile);
				fileModel.setStatus(Constant.STATUS_FILE);
				fileModel.setDescription(nameFile +" -- "+ bucketName);
				iFileDAO.save(fileModel);
			}
		} catch (Exception e) {
			logger.info("ERROR SAVE FILE IN FileServiceImpl: ", e);
			return false;
		}
		return true;
	}

	@Override
	@Transactional(rollbackFor = Throwable.class, propagation = Propagation.REQUIRES_NEW)
	public FileS3 findById(Integer id) throws Exception {
		try {
			FileS3 fileS3 = iFileDAO.findById(id);
			if (fileS3 != null) {
				return fileS3;
			}
		} catch (Exception e) {
			logger.info("ERROR GET FILE BY ID", e);
		}
		return null;
	}

}
