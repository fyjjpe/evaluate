package com.dao;

import com.model.DCourse;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/6.
 */
@Repository("dCourseDao")
public interface DCourseDao {
    List<DCourse> findAllCourses();

    DCourse findById(@Param("cid") Integer cid);

    DCourse findByName(@Param("name") String name);

    void updateCourse(@Param("cid") Integer cid, @Param("name") String name, @Param("fullScore") Integer fullScore);

    void saveCourse(@Param("name") String name, @Param("fullScore") Integer fullScore);

    void deleteCourse(@Param("cid") Integer cid);
}
