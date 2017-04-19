package vn.framgia.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import vn.framgia.dao.ICityDAO;
import vn.framgia.dao.IFileDAO;
import vn.framgia.dao.IFilmDAO;
import vn.framgia.dao.IScheduleDAO;

import java.io.Serializable;

/**
 * Created by FRAMGIA\duong.van.tien on 06/03/2017.
 *
 */
public class BaseserviceImpl implements Serializable {

    @Autowired
    protected ICityDAO iCityDAO;

    @Autowired
    protected IFilmDAO iFilmDAO;

    @Autowired
    protected IScheduleDAO iScheduleDAO;
    
    @Autowired
    protected IFileDAO iFileDAO;
}
