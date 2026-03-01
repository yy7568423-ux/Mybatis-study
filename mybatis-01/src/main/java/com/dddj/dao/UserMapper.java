package com.dddj.dao;

import com.dddj.pojo.User;

import java.util.List;
import java.util.Map;

/**
 * @author DDDJ
 **/
public interface UserMapper {
    //查询所有用户
    List<User> getUserList();

    //模糊查询
    List<User> getUserLike(String value);

    //根据id查询用户
    User getUserById(int id);

    //插入用户
    int addUser(User user);

    //map
    int addUser2(Map<String, Object> map);
    int deleteUserByMap(Map<String, Object> map);

    //修改用户
    int updateUser(User user);

    //删除用户
    int deleteUser(int id);
}
