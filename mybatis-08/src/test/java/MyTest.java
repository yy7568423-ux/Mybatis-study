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
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User user1 = mapper.queryUserById(1);
        System.out.println(user1);
        //手动清理缓存
        sqlSession.clearCache();

        System.out.println("===================");
        mapper.updateUser(new User(2,"DDD","12345678"));
        User user2 = mapper.queryUserById(1);
        System.out.println(user2);
        sqlSession.close();
    }
}
/*
一级缓存作用域：SqlSession内
一级缓存失效的情况
1.查询不同的对象
2.增删改查，可能会改变原来的数据，所以必定会刷新缓存
3.查询不同的Mapper.xml
4.手动清理缓存
 */
