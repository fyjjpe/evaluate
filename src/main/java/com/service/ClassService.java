package com.service;

import com.model.DClass;

import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/6.
 */
public interface ClassService {
    //查询所有班级信息
    List<DClass> findAllClasses();

    //查询某个班级
    DClass findById(Integer cid);

    //根据名字查询某个班级
    DClass findByName(String name);

    //修改班级信息
    void updateClass(Integer cid, String name, String course);

    //新增班级
    void saveClass(String name, String course);

    //删除班级
    void deleteClass(Integer cid);
}
