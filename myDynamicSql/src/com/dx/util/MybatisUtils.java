package com.dx.util;




import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.Reader;

public class MybatisUtils {
    private static SqlSessionFactory sqlSessionFactory;
    static {//static块-------只做一次

        try {
            //使用mybatis提供的resource类加载mybatis的配置文件
            Reader reader= Resources.getResourceAsReader("mybatis-config.xml");
            //构建SqlSessionFactory工厂
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(reader);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    //获取SqlSession的静态方法
    public static SqlSession getSession(boolean flag){
        return sqlSessionFactory.openSession(flag);
    }

    //关闭方法
    public static void closeSqlSession(SqlSession sqlSession){
        if(null!=sqlSession){
            sqlSession.close();
        }
    }
}