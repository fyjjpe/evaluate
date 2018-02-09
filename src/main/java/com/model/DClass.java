package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanjie.fang on 2018/2/5.
 */
public class DClass implements Serializable {

    private static final long serialVersionUID = -3276050043790379916L;
    //班级id
    private Integer id;
    //班级名称
    private String name;
    //班级课程
    private String course;
    //创建时间
    private Date createDate;
    //修改时间
    private Date updateDate;
    //是否删除,0-不删除(默认)，1-删除
    private Integer isDelete;

    public DClass() {
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

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    @Override
    public String toString() {
        return "DClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", course='" + course + '\'' +
                ", createDate=" + createDate +
                ", updateDate=" + updateDate +
                ", isDelete=" + isDelete +
                '}';
    }
}
