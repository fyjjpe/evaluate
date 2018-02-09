package com.service.impl;

import com.dao.DCourseDao;
import com.model.DCourse;
import com.service.CourseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/6.
 */
@Service("courseService")
public class CourseServiceImpl implements CourseService {
    @Resource(name = "dCourseDao")
    private DCourseDao dCourseDao;

    @Override
    public List<DCourse> findAllCourses() {
        try {
            return dCourseDao.findAllCourses();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DCourse findById(Integer cid) {
        try {
            return dCourseDao.findById(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DCourse findByName(String name) {
        try {
            return dCourseDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateCourse(Integer cid, String name, Integer fullScore) {
        try {
            dCourseDao.updateCourse(cid,name,fullScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveCourse(String name, Integer fullScore) {
        try {
            dCourseDao.saveCourse(name,fullScore);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteCourse(Integer cid) {
        try {
            dCourseDao.deleteCourse(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
