package dao;

import com.dddj.dao.UserMapper;
import com.dddj.pojo.User;
import com.dddj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.List;

/**
 * @author DDDJ
 **/
public class UserMapperTest {

    static Logger logger =Logger.getLogger(UserMapperTest.class);
    @Test
    public void getUserList(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        logger.info("i测试:进入方法");
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

    }
   }