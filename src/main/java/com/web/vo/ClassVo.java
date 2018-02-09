package com.web.vo;

import com.model.DCourse;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/6.
 * 页面显示的班级实体类
 */
public class ClassVo implements Serializable{

    private static final long serialVersionUID = 6315641493514391695L;

    //班级id
    private Integer id;
    //班级名称
    private String name;
    //班级课程
    private String course;
    //创建时间
    private String createDate;
    //修改时间
    private String updateDate;
    //展示所有的课程
    private List<DCourse> courses;

    public ClassVo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate;
    }

    public List<DCourse> getCourses() {
        return courses;
    }

    public void setCourses(List<DCourse> courses) {
        this.courses = courses;
    }
}
