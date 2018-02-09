package com.web.vo;

import java.io.Serializable;

/**
 * Created by yuanjie.fang on 2018/2/7.
 */
public class StudentVo implements Serializable {

    private static final long serialVersionUID = 7352548502707447894L;

    //编号
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
    private String selfDate;
    //创建时间
    private String createDate;
    //修改时间
    private String updateDate;

    public StudentVo() {
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

    public String getSelfDate() {
        return selfDate;
    }

    public void setSelfDate(String selfDate) {
        this.selfDate = selfDate;
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
}
