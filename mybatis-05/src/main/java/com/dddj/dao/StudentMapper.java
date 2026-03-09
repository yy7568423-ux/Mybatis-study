package com.dddj.dao;

import com.dddj.pojo.Student;

import java.util.List;

/**
 * @author DDDJ
 **/
public interface StudentMapper {
    //查询所有学生信息，并且查询出每个学生的老师信息
    List<Student> getStudent();
    List<Student> getStudent2();
}
