package dao;

import com.dddj.dao.UserMapper;
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
    public void getUserList() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> user = userMapper.getUsers();
        for (User u : user) {
            System.out.println(u);
        }
        }

    @Test
    public void getUserById() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user = userMapper.getUserById(1);
        System.out.println(user);
    }

    @Test
    public void addUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.addUser(new User(6, "Dj", "123456"));
        if (res > 0) {
            System.out.println("插入成功");
        }
    }

    @Test
    public void deleteUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.deleteUser(6);
        if (res > 0) {
            System.out.println("删除成功");
        }
    }

    @Test
    public void updateUser() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        int res = userMapper.updateUser(new User(5, "Dj", "123456"));
        if (res > 0) {
            System.out.println("更新成功");
        }
    }



    }
