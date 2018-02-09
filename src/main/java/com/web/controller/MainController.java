package com.web.controller;

import com.model.DClass;
import com.service.ClassService;
import com.service.CourseService;
import com.utils.StringUtil;
import com.web.vo.ClassVo;
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
public class MainController {
    @Resource(name = "classService")
    private ClassService classService;

    @Resource(name = "courseService")
    private CourseService courseService;

    /**
     * 首次进入时
     *
     * @param req
     * @param res
     * @throws Exception
     */
    @RequestMapping(value = "login.action", method = RequestMethod.GET)
    public void login(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher("WEB-INF/main.jsp").forward(req, res);
    }


    @RequestMapping(value = "findAllClasses.action", method = RequestMethod.GET)
    @ResponseBody
    public List<ClassVo> findAllClasses() throws Exception {
        List<ClassVo> classVos = new ArrayList<>();
        try {
            List<DClass> allClasses = classService.findAllClasses();
            if (allClasses == null || allClasses.size() == 0) {
                return null;
            }
            for (DClass aClass : allClasses) {
                classVos.add(convert(aClass));
            }
            return classVos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //将数据库查询的班级转换为页面显示的班级样式
    private ClassVo convert(DClass dClass) {
        ClassVo classVo = new ClassVo();
        if (dClass != null) {
            classVo.setId(dClass.getId());
            classVo.setName(dClass.getName());
            classVo.setCourse(dClass.getCourse());
            classVo.setCreateDate(StringUtil.dateToString(dClass.getCreateDate()));
            classVo.setUpdateDate(StringUtil.dateToString(dClass.getUpdateDate()));
        }
        return classVo;
    }

    @RequestMapping(value = "findClass.action", method = RequestMethod.POST)
    @ResponseBody
    public ClassVo findClass(Integer cid) {
        try {
            DClass dClass = classService.findById(cid);
            ClassVo classVo = convert(dClass);
            classVo.setCourses(courseService.findAllCourses());
            return classVo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "searchClass.action", method = RequestMethod.POST)
    @ResponseBody
    public List<ClassVo> findClassByName(String name) {
        List<ClassVo> classVos = new ArrayList<>();
        try {
            DClass dClass = classService.findByName(name);
            ClassVo classVo = convert(dClass);
            classVos.add(classVo);
            return classVos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "updateClass.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateClass(Integer cid, String name, String course) {
        try {
            classService.updateClass(cid, name, course);
            return "1";//1-表示修改成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示修改失败
    }

    @RequestMapping(value = "addClass.action", method = RequestMethod.POST)
    @ResponseBody
    public String addClass(String name, String course) {
        try {
            //首先查询该名称的班组是否已经注册了
            DClass dClass = classService.findByName(name);
            if (dClass != null) {
                return "3";//3-表示班组已经被注册了
            }
            classService.saveClass(name, course);
            return "1";//1-表示新增成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示新增失败
    }

    @RequestMapping(value = "deleteClass.action", method = RequestMethod.POST)
    @ResponseBody
    public String deleteClass(Integer cid) {
        try {
            classService.deleteClass(cid);
            return "1";//1-表示删除成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示删除失败
    }

}
