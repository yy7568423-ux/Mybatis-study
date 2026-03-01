package com.dddj.dao;

import com.dddj.pojo.User;
import com.dddj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author DDDJ
 **/
public class UserMapperTest {
    @Test
    public void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserLike("李");
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }
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


    @Test
    public void addUser2(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Object> map = new HashMap<>();
        map.put("userid",5);
        map.put("username","DDJ");
        map.put("password","123456");
        int res =mapper.addUser2(map);
        if(res > 0){
            System.out.println("插入成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
    @Test
    public void deleteUserByMap() {
        // 1. 获取 SqlSession（如果没开自动提交，后续要手动 commit）
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        // 2. 创建 Map，封装删除条件（对应你插入的 userid=5）
        Map<String, Object> map = new HashMap<>();
        map.put("userid", 5); // 要删除的用户 id

        // 3. 执行删除方法
        int res = mapper.deleteUserByMap(map);
        if (res > 0) {
            System.out.println("删除成功，影响行数：" + res);
            // 关键：如果 MybatisUtils 没开自动提交，必须手动提交事务
            sqlSession.commit();
        } else {
            System.out.println("删除失败，未找到对应数据");
        }

        // 4. 关闭 SqlSession
        sqlSession.close();
    }
}