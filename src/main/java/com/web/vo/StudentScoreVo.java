package com.web.vo;

import java.io.Serializable;
import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/8.
 */
public class StudentScoreVo implements Serializable {
    private static final long serialVersionUID = 3335538113624257539L;

    private Integer id;
    private String number;
    private String name;
    private String className;
    private List<ScoreVo> scoreVos;

    public StudentScoreVo() {
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

    public List<ScoreVo> getScoreVos() {
        return scoreVos;
    }

    public void setScoreVos(List<ScoreVo> scoreVos) {
        this.scoreVos = scoreVos;
    }
}
