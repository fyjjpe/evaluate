package com.service.impl;

import com.dao.DClassDao;
import com.model.DClass;
import com.service.ClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/6.
 */
@Service("classService")
public class ClassServiceImpl implements ClassService {

    @Resource(name = "dClassDao")
    private DClassDao dClassDao;

    @Override
    public List<DClass> findAllClasses() {
        try {
            return dClassDao.findAllClasses();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DClass findById(Integer cid) {
        try {
            return dClassDao.findById(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DClass findByName(String name) {
        try {
            return dClassDao.findByName(name);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public void updateClass(Integer cid, String name, String course) {
        try {
            dClassDao.updateClass(cid, name, course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void saveClass(String name, String course) {
        try {
            dClassDao.saveClass(name,course);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteClass(Integer cid) {
        try {
            dClassDao.deleteClass(cid);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
