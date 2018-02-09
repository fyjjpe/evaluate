package com.dao;

import com.model.DStudent;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/6.
 */
@Repository("dStudentDao")
public interface DStudentDao {
    //查询所有学生
    List<DStudent> findAllStudents();

    //根据ID查询学生
    DStudent findById(@Param("sid") Integer sid);

    //更加名称搜索学生
    DStudent findByName(@Param("name") String name);

    //修改学生表信息
    void updateStudent(@Param("sid") Integer sid, @Param("name") String name, @Param("className") String className,
                       @Param("score") String score, @Param("scoreBySelf") Integer scoreBySelf,
                       @Param("isPass") Integer isPass, @Param("selfDate") Date selfDate, @Param("updateDate") Date updateDate);

    //新增学生
    void saveStudent(@Param("number") String number, @Param("name") String name, @Param("className") String className);

    //删除学生
    void deleteStudent(@Param("sid") Integer sid);
}
