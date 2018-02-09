package com.web.controller;

import com.alibaba.fastjson.JSONObject;
import com.model.DClass;
import com.model.DStudent;
import com.service.ClassService;
import com.service.StudentService;
import com.utils.StringUtil;
import com.web.vo.ScoreVo;
import com.web.vo.StudentScoreVo;
import com.web.vo.StudentVo;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

/**
 * Created by yuanjie.fang on 2018/2/5.
 */
@Controller
public class StudentController {

    @Resource(name = "studentService")
    private StudentService studentService;

    @Resource(name = "classService")
    private ClassService classService;

    @RequestMapping(value = "student.action", method = RequestMethod.GET)
    public void showStudent(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher("WEB-INF/student.jsp").forward(req, res);
    }

    @RequestMapping(value = "own.action", method = RequestMethod.GET)
    public void showOwn(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher("WEB-INF/own.jsp").forward(req, res);
    }

    @RequestMapping(value = "group.action", method = RequestMethod.GET)
    public void showGroup(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher("WEB-INF/group.jsp").forward(req, res);
    }

    @RequestMapping(value = "result.action", method = RequestMethod.GET)
    public void showResult(HttpServletRequest req, HttpServletResponse res) throws Exception {
        req.getRequestDispatcher("WEB-INF/result.jsp").forward(req, res);
    }


    @RequestMapping(value = "findAllStudents.action", method = RequestMethod.GET)
    @ResponseBody
    public List<StudentVo> findAllStudents() throws Exception {
        List<StudentVo> StudentVos = new ArrayList<>();
        try {
            List<DStudent> allStudents = studentService.findAllStudents();
            for (DStudent Student : allStudents) {
                StudentVos.add(convert(Student));
            }
            return StudentVos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    private StudentVo convert(DStudent dStudent) {
        StudentVo studentVo = new StudentVo();
        if (dStudent != null) {
            studentVo.setId(dStudent.getId());
            studentVo.setNumber(dStudent.getNumber());
            studentVo.setName(dStudent.getName());
            studentVo.setClassName(dStudent.getClassName());
            studentVo.setScore(dStudent.getScore());
            studentVo.setScoreBySelf(dStudent.getScoreBySelf());
            studentVo.setIsPass(dStudent.getIsPass());
            studentVo.setSelfDate(StringUtil.dateToString(dStudent.getSelfDate()));
            studentVo.setCreateDate(StringUtil.dateToString(dStudent.getCreateDate()));
            studentVo.setUpdateDate(StringUtil.dateToString(dStudent.getUpdateDate()));
        }
        return studentVo;
    }

    @RequestMapping(value = "findStudent.action", method = RequestMethod.POST)
    @ResponseBody
    public StudentVo findStudent(Integer sid) {
        try {
            DStudent dStudent = studentService.findById(sid);
            return convert(dStudent);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "searchStudent.action", method = RequestMethod.POST)
    @ResponseBody
    public List<StudentVo> findStudentByName(String name) {
        List<StudentVo> StudentVos = new ArrayList<>();
        try {
            DStudent dStudent = studentService.findByName(name);
            StudentVo StudentVo = convert(dStudent);
            StudentVos.add(StudentVo);
            return StudentVos;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @RequestMapping(value = "updateStudent.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateStudent(Integer sid, String name, String className) {
        try {
            studentService.updateStudent(sid, name, className, null, null, null, null, new Date());
            return "1";//1-表示修改成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示修改失败
    }

    @RequestMapping(value = "addStudent.action", method = RequestMethod.POST)
    @ResponseBody
    public String addStudent(String number, String name, String className) {
        try {
            //首先查询该名称的班组是否已经注册了
            DStudent dStudent = studentService.findByName(name);
            if (dStudent != null) {
                return "3";//3-表示班组已经被注册了
            }
            studentService.saveStudent(number,name, className);
            return "1";//1-表示新增成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示新增失败
    }

    @RequestMapping(value = "deleteStudent.action", method = RequestMethod.POST)
    @ResponseBody
    public String deleteStudent(Integer sid) {
        try {
            studentService.deleteStudent(sid);
            return "1";//1-表示删除成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示删除失败
    }

    //学生自评
    @RequestMapping(value = "ownStudentUpdate.action", method = RequestMethod.POST)
    @ResponseBody
    public String ownStudentUpdate(Integer sid, Integer scoreBySelf) {
        try {
            studentService.updateStudent(sid, null, null, null, scoreBySelf, null, new Date(), null);
            return "1";//1-表示修改成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示修改失败
    }


    //验证学生自评
    @RequestMapping(value = "check.action", method = RequestMethod.GET)
    public String checkStudentScoreBySelf(Integer sid, Integer isPass) {
        try {
            studentService.updateStudent(sid, null, null, null, null, isPass, new Date(), null);
            return "group";//1-表示修改成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "验证失败";//2-表示修改失败
    }

    //查询学生成绩
    @RequestMapping(value = "findStudentScore.action", method = RequestMethod.POST)
    @ResponseBody
    public StudentScoreVo findStudentScore(Integer sid) {
        try {
            //返回给前端的对象
            StudentScoreVo studentScoreVo = new StudentScoreVo();
            DStudent dStudent = studentService.findById(sid);
            DClass dClass = classService.findByName(dStudent.getClassName());
            if (dClass == null) {
                studentScoreVo.setClassName("班级不存在");
                return studentScoreVo;
            }
            //获取一个班级所有的课程
            String course = dClass.getCourse();
            String[] courses = course.split(",");
            //获取已经登记的分数
            String score = dStudent.getScore();
            List<ScoreVo> scoreVos = convertToScoreVo(score);
            for (String s : courses) {
                if (score == null) {
                    score = "xx";
                }
                if (!score.contains(s)) {
                    ScoreVo scoreVo = new ScoreVo();
                    scoreVo.setCourseName(s);
                    scoreVo.setScore("未录入");
                    scoreVos.add(scoreVo);
                }
            }
            studentScoreVo.setId(sid);
            studentScoreVo.setNumber(dStudent.getNumber());
            studentScoreVo.setName(dStudent.getName());
            studentScoreVo.setClassName(dStudent.getClassName());
            studentScoreVo.setScoreVos(scoreVos);
            return studentScoreVo;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    //学生分数转换为分数对象
    private List<ScoreVo> convertToScoreVo(String score) {
        List<ScoreVo> scoreVos = new ArrayList<>();
        if (score != null && !score.equals("")) {
            JSONObject jsonObject = JSONObject.parseObject(score);
            Set<String> strings = jsonObject.keySet();
            for (String str : strings) {
                ScoreVo scoreVo = new ScoreVo();
                scoreVo.setCourseName(str);
                scoreVo.setScore(String.valueOf(jsonObject.getInteger(str)));
                scoreVos.add(scoreVo);
            }
        }
        return scoreVos;
    }

    //提交学生基础成绩
    //学生自评
    @RequestMapping(value = "updateStudentScore.action", method = RequestMethod.POST)
    @ResponseBody
    public String updateStudentScore(Integer sid, String score) {

        try {
            //保存进入数据库的数据
            String str = "{";
            String[] scores = score.split(",");
            //定义一个需保存的分数集合
            List<String> newScore = new ArrayList<>();
            for (int i = 0; i < scores.length; i++) {
                if (!scores[i].contains("未录入")) {
                    newScore.add(scores[i]);
                }
            }
            if (newScore != null && newScore.size() > 0) {
                for (int j = 0; j < newScore.size(); j++) {
                    if (j == newScore.size() - 1) {
                        str += newScore.get(j) + "}";
                    } else {
                        str += newScore.get(j) + ",";
                    }
                }
            }
            if (!"{".equals(str)) {
                studentService.updateStudent(sid, null, null, str, null, null, null, new Date());
            }
            return "1";//1-表示修改成功
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "2";//2-表示修改失败
    }
}
