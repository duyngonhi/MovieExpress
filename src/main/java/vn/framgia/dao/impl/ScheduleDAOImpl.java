package vn.framgia.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;
import vn.framgia.dao.IScheduleDAO;
import vn.framgia.model.Film;
import vn.framgia.model.Schedule;

import java.util.Date;
import java.util.List;

/**
 * Created by FRAMGIA\duong.van.tien on 10/04/2017.
 */
@Repository
public class ScheduleDAOImpl extends GenericDAO<Schedule, Integer> implements IScheduleDAO {
    public ScheduleDAOImpl() {
        super.setPersistentClass(Schedule.class);
    }

    @Override
    public List<Schedule> findScheduleToday(String today) {
        Criteria criteria = getHibernateTemplate().getSessionFactory().openSession().createCriteria(Schedule.class);
        return criteria.add(Restrictions.like("day", "%"+today+"%")).list();
    }
}
