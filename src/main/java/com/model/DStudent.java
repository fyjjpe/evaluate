package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanjie.fang on 2018/2/6.
 */
public class DStudent implements Serializable {

    private static final long serialVersionUID = -5808273605364813728L;

    //id
    private Integer id;
    //学号
    private String number;
    //学生姓名
    private String name;
    //班级名
    private String className;
    //学生基本成绩
    private String score;
    //自评成绩
    private Integer scoreBySelf;
    //自评是否通过(0-未审核，1-已通过，2-未通过)
    private Integer isPass;
    //自评时间
    private Date selfDate;
    //创建时间
    private Date createDate;
    //修改时间
    private Date updateDate;
    //是否删除(0-不删除，1-删除)
    private Integer isDelete;

    public DStudent() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Integer getScoreBySelf() {
        return scoreBySelf;
    }

    public void setScoreBySelf(Integer scoreBySelf) {
        this.scoreBySelf = scoreBySelf;
    }

    public Integer getIsPass() {
        return isPass;
    }

    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
    }

    public Date getSelfDate() {
        return selfDate;
    }

    public void setSelfDate(Date selfDate) {
        this.selfDate = selfDate;
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
}
