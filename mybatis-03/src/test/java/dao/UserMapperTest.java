package dao;

import com.dddj.dao.UserMapper;
import com.dddj.pojo.User;
import com.dddj.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;

/**
 * @author DDDJ
 **/
public class UserMapperTest {

    static Logger logger =Logger.getLogger(UserMapperTest.class);
    @Test
    public void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        logger.info("测试:进入方法");
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.getUserList();
        for (User user : userList) {
            System.out.println(user);
        }
        sqlSession.close();
    }

    //简单引用log4j
    @Test
    public void testLog4j(){
        logger.info("info:进入方法");
        logger.debug("debug:进入方法");
        logger.error("error:进入方法");

    }

    @Test
    public void getUserById(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);

        HashMap<String, Integer> map = new HashMap<>();
        map.put("startIndex",0);
        map.put("pageSize",2);
        List<User> userList = userMapper.getUserByLimit(map);
        for (User user : userList) {
            System.out.println(user);
        }

    }

    //基于JAVA实现分页，RowBounds实现
    @Test
    public void getUserByRowBounds(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        //RowBounds
        RowBounds rowBounds = new RowBounds(1,2);
        List<User> userList = sqlSession.selectList("com.dddj.dao.UserMapper.getUserByRowBounds", null, rowBounds);
        for (User user : userList) {
            System.out.println(user);
        }

    }
   }