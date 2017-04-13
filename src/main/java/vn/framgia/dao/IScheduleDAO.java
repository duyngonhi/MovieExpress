package vn.framgia.dao;

import vn.framgia.model.Schedule;

import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 10/04/2017.
 */
public interface IScheduleDAO extends IGenericDAO<Schedule, Integer> {
    public List<Schedule> findScheduleToday(String today);
}
