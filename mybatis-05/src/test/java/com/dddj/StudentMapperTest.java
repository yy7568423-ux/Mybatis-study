package com.dddj;

import com.dddj.dao.StudentMapper;
import com.dddj.pojo.Student;
import com.dddj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.sql.ClientInfoStatus;
import java.util.List;

/**
 * @author DDDJ
 **/
public class StudentMapperTest {
    @Test
    public void getStudent() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent();
        for (Student s : student) {
            System.out.println(s);
        }
    }
    @Test
    public void getStudent2() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        StudentMapper mapper = sqlSession.getMapper(StudentMapper.class);
        List<Student> student = mapper.getStudent2();
        for (Student s : student) {
            System.out.println(s);
        }
    }


}
