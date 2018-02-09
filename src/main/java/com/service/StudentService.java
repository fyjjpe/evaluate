package com.service;

import com.model.DStudent;

import java.util.Date;
import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/7.
 */
public interface StudentService {

    //查询所有的班级
    List<DStudent> findAllStudents();

    //根据id查询某个学生
    DStudent findById(Integer sid);

    //根据名称查询某个学生
    DStudent findByName(String name);

    //修改学生信息
    void updateStudent(Integer sid, String name, String className, String score,
                       Integer scoreBySelf, Integer isPass, Date selfDate, Date updateDate);

    //新增学生
    void saveStudent(String number, String name, String className);

    //删除学生
    void deleteStudent(Integer sid);

}
