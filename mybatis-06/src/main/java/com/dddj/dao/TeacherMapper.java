package com.dddj.dao;

import com.dddj.pojo.Teacher;
import org.apache.ibatis.annotations.Param;

/**
 * @author DDDJ
 **/
public interface TeacherMapper {

    //获取指定老师下的所有学生及老师信息
    // 加@Param：显式指定参数名为id，XML中可直接用#{id}引用
    Teacher getTeacher(@Param("tid") int id);
    Teacher getTeacher2(@Param("tid") int id);

}
