package com.dddj.dao;

import com.dddj.pojo.User;
import com.dddj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;

/**
 * @author DDDJ
 **/
public class UserMapperTest {
    @Test
    public void test(){
        // 1、获取SqlSession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        //2、执行SQL,方式一：getMapper
        UserMapper userDao = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userDao.getUserList();

        //方式二
//        List<User> userList = sqlSession.selectList("com.dddj.dao.UserDao.getUserList");

        //遍历
        for (User user : userList) {
            System.out.println(user);
        }
        //关闭SqlSession
        sqlSession.close();


    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }

    @Test
//     增删改需要提交事务
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        int res = mapper.addUser(new User(4,"DDDJ","123456"));
        if(res > 0){
            System.out.println("插入成功");
        }
        //提交事务
        sqlSession.commit();

        sqlSession.close();
    }

    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.updateUser(new User(4,"DDDJ","666666"));
        if(res > 0){
            System.out.println("更新成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        int res = mapper.deleteUser(4);
        if(res > 0){
            System.out.println("删除成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
