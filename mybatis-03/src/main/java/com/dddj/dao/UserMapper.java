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

    //分页
    List<User> getUserByLimit(Map<String,Integer> map);
    //分页2
    List<User> getUserByRowBounds();
}