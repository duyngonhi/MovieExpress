package vn.framgia.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import vn.framgia.bean.FileBean;
import vn.framgia.model.FileS3;

public interface IFileService extends Serializable {
	public List<FileBean> findAllFile() throws Exception;
	public boolean saveFileToDb(MultipartFile[] files, String bucketName) throws Exception;
	public FileS3 findById(Integer id) throws Exception;
}
