package vn.framgia.dao;

import vn.framgia.model.FileS3;

public interface IFileDAO extends IGenericDAO<FileS3, Integer> {
	public FileS3 findById(Integer id);
}
