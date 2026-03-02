package com.dddj.dao;
import com.dddj.pojo.User;

import java.util.List;

/**
 * @author DDDJ
 **/
public interface UserMapper {
    //查询所有用户
    List<User> getUserList();
}