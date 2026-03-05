package com.dddj.dao;
import com.dddj.pojo.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @author DDDJ
 **/
public interface UserMapper {
    //查询所有用户
    @Select("select * from user")
    List<User> getUsers();

    //方法存在多个参数，所有参数都使用@Param注解
    @Select("select * from user where id = #{id}")
    User getUserById(@Param("id") int id);

    @Insert("insert into user(id,name,pwd) values(#{id},#{name},#{password})")
    int addUser(User user);

    @Delete("delete from user where id = #{id}")
    int deleteUser(@Param("id") int id);

    @Update("update user set name = #{name},pwd = #{password} where id = #{id}")
    int updateUser(User user);

}