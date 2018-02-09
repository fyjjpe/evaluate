package com.model;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanjie.fang on 2018/2/6.
 * 课程实体类
 */
public class DCourse implements Serializable {
    private static final long serialVersionUID = 2170804553235580379L;

    private Integer id;
    private String name;
    private Date createDate;
    private Date updateDate;
    private Integer fullScore;
    private Integer isDelete;

    public DCourse() {
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

    public Integer getFullScore() {
        return fullScore;
    }

    public void setFullScore(Integer fullScore) {
        this.fullScore = fullScore;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }
}
