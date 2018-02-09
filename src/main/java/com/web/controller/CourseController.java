package com.web.controller;

import com.model.DCourse;
import com.service.CourseService;
import com.utils.StringUtil;
import com.web.vo.CourseVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/5.
 */
@Controller
public class CourseController {

    @Resource(name = "courseService")
    private CourseService courseService;

    @RequestMapping(value = "course.action", method = RequestMethod.GET)
    public void showCourse(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher("WEB-INF/course.jsp").forward(req, res);
    }


    @RequestMapping(value = "findAllCourses.action", method = RequestMethod.GET)
    @ResponseBody
    public List<CourseVo> findAllCourses() throws Exception {
        List<CourseVo> courseVos = new ArrayList<>();
        try {
            List<DCourse> allCourses = courseService.findAllCourses();
            for (DCourse course : allCourses) {
                courseVos.add(convert(course));
            }
            return courseVos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private CourseVo convert(DCourse dCourse) {
        CourseVo courseVo = new CourseVo();
        if (dCourse != null) {
            courseVo.setId(dCourse.getId());
            courseVo.setName(dCourse.getName());
            courseVo.setCreateDate(StringUtil.dateToString(dCourse.getCreateDate()));
            courseVo.setUpdateDate(StringUtil.dateToString(dCourse.getUpdateDate()));
            courseVo.setFullScore(dCourse.getFullScore());
        }
        return courseVo;
    }

    @RequestMapping(value = "findCourse.action", method = RequestMethod.POST)
    @ResponseBody
    public CourseVo findCourse(Integer cid) {
        try {
            DCourse dCourse = courseService.findById(cid);
            return convert(dCourse);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "searchCourse.action", method = RequestMethod.POST)
    @ResponseBody
    public List<CourseVo> findCourseByName(String name) {
        List<CourseVo> courseVos = new ArrayList<>();
        try {
            DCourse dCourse = courseService.findByName(name);
            CourseVo courseVo = convert(dCourse);
            courseVos.add(courseVo);
            return courseVos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "updateCourse.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateCourse(Integer cid, String name, Integer fullScore) {
        try {
            courseService.updateCourse(cid, name, fullScore);
            return "1";//1-表示修改成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示修改失败
    }

    @RequestMapping(value = "addCourse.action", method = RequestMethod.POST)
    @ResponseBody
    public String addCourse(String name, Integer fullScore) {
        try {
            //首先查询该名称的班组是否已经注册了
            DCourse dCourse = courseService.findByName(name);
            if (dCourse != null) {
                return "3";//3-表示班组已经被注册了
            }
            courseService.saveCourse(name, fullScore);
            return "1";//1-表示新增成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示新增失败
    }

    @RequestMapping(value = "deleteCourse.action", method = RequestMethod.POST)
    @ResponseBody
    public String deleteCourse(Integer cid) {
        try {
            courseService.deleteCourse(cid);
            return "1";//1-表示删除成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示删除失败
    }


}
