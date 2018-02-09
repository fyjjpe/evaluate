package com.service.impl;

import com.dao.DStudentDao;
import com.model.DStudent;
import com.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/7.
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource(name = "dStudentDao")
    private DStudentDao dStudentDao;

    @Override
    public List<DStudent> findAllStudents() {
        try {
            return dStudentDao.findAllStudents();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DStudent findById(Integer sid) {
        try {
            return dStudentDao.findById(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DStudent findByName(String name) {
        try {
            return dStudentDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateStudent(Integer sid, String name, String className, String score, Integer scoreBySelf, Integer isPass, Date selfDate, Date updateDate) {
        try {
            dStudentDao.updateStudent(sid, name, className, score, scoreBySelf, isPass, selfDate, updateDate);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveStudent(String number, String name, String className) {
        try {
            dStudentDao.saveStudent(number, name, className);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteStudent(Integer sid) {
        try {
            dStudentDao.deleteStudent(sid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
