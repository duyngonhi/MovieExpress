package vn.framgia.dao.impl;

import org.springframework.stereotype.Repository;

import vn.framgia.dao.IFileDAO;
import vn.framgia.model.FileS3;

@Repository
public class FileDAOImpl extends GenericDAO<FileS3, Integer> implements IFileDAO {
	public FileDAOImpl(){
		super.setPersistentClass(FileS3.class);
	}

	@Override
	public FileS3 findById(Integer id) {
		return getHibernateTemplate().get(FileS3.class, id);
	}
}
