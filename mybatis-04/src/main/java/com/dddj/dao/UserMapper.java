package com.dddj.dao;
import com.dddj.pojo.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author DDDJ
 **/
public interface UserMapper {
    //查询所有用户
    @Select("select * from user")
    List<User> getUsers();

}