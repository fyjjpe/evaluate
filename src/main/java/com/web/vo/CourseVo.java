package com.web.vo;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by yuanjie.fang on 2018/2/6.
 */
public class CourseVo implements Serializable {
    private static final long serialVersionUID = -2026351063506704455L;

    private Integer id;
    private String name;
    private String createDate;
    private String updateDate;
    private Integer fullScore;

    public CourseVo() {
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

    public Integer getFullScore() {
        return fullScore;
    }

    public void setFullScore(Integer fullScore) {
        this.fullScore = fullScore;
    }
}
