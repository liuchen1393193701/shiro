package com.woniu.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

public class MyUtil {
    static ThreadLocal<SqlSession> tl = new ThreadLocal<SqlSession>();
    private static SqlSessionFactory sf;
    static{
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            sf =new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static SqlSession getSession(){
        SqlSession session =tl.get();
        if (session==null) {
            session = sf.openSession();
            tl.set(session);
        }
        return session;
    }

    public static void closeSession(){
        SqlSession session = tl.get();
        if(session!=null){
            session.close();
            tl.set(null);
        }
    }

    private static SqlSessionFactory sqlSessionFactory;
    static {
        try {
            InputStream in= Resources.getResourceAsStream("mybatis-config.xml");
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static SqlSession createSqlSession(){
        return sqlSessionFactory.openSession();
    }
}
