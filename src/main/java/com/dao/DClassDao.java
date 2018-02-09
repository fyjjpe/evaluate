package com.dao;

import com.model.DClass;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by yuanjie.fang on 2018/2/5.
 */
@Repository("dClassDao")
public interface DClassDao {
    List<DClass> findAllClasses();

    DClass findById(@Param("cid") Integer cid);

    DClass findByName(@Param("name") String name);

    void updateClass(@Param("cid") Integer cid, @Param("name") String name, @Param("course") String course);

    void saveClass(@Param("name") String name, @Param("course") String course);

    void deleteClass(@Param("cid") Integer cid);
}
