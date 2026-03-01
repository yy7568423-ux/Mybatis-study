package com.dddj.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @author DDDJ
 **/


//工具类SqlSessionFactory
public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;//扩大静态作用域

    //设置成静态，方便调用
    static {
        //获取SqlSessionFactory对象,使用MyBatis的第一步
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
             sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            throw new RuntimeException("初始化 SqlSessionFactory 失败，请检查配置文件路径或数据库配置");
        }
    }
    public static SqlSession getSqlSession(){
        //优化前
        //SqlSession sqlSession = sqlSessionFactory.openSession();
        //return sqlSession;
        //优化后
        return sqlSessionFactory.openSession();

    }

}
