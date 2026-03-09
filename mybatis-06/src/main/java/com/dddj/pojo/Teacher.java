package com.dddj.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author DDDJ
 **/
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    private int id;
    private String name;

    //一个老师对应多个学生
    private List<Student> students;
}
