import com.dddj.dao.UserMapper;
import com.dddj.pojo.User;
import com.dddj.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

/**
 * @author DDDJ
 **/
public class MyTest {
    @Test
    public void test1(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        SqlSession sqlSession2 = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);

        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        sqlSession.close();

        System.out.println("===================");

        User user2 = mapper2.queryUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }
}
