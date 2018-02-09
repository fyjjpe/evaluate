package com.service;

import com.model.DCourse;

import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/6.
 */
public interface CourseService {
    //查询所有的课程
    List<DCourse> findAllCourses();

    DCourse findById(Integer cid);

    DCourse findByName(String name);

    void updateCourse(Integer cid, String name, Integer fullScore);

    void saveCourse(String name, Integer fullScore);

    void deleteCourse(Integer cid);
}
