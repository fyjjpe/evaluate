package com.web.vo;

import java.io.Serializable;

/**
 * Created by yuanjie.fang on 2018/2/8.
 */
public class ScoreVo implements Serializable {

    private static final long serialVersionUID = -3258536235481045873L;

    private String courseName;
    private String score;

    public ScoreVo() {
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }
}
