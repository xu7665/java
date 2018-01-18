package com.xuxu.mybatis.juit;


import com.xuxu.mybatis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.Date;
import java.util.List;

public class MybatiesTest {
    @Test
    public void testMybaties() throws Exception {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        User user = sqlSession.selectOne("test.findUserById", 5);
        System.out.println(user);
    }

    @Test
    public void FindUsername() throws Exception {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        List<User> users = sqlSession.selectList("test.FindUsername", "王");
        for (User user1 : users)
            System.out.println(user1);
    }

    @Test
    public void insertUser() throws Exception {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        //List<User> users = sqlSession.selectList("test.FindUsername", "王");
        User user = new User();
        //   user.setId(7);
        user.setUsername("郭德刚");
        user.setBirthday(new Date());
        user.setAddress("天安门l555555555l");
        user.getSex("男");
        int i = sqlSession.insert("test.insertUser", user);
        sqlSession.commit();
        System.out.println(user.getId());

        //for (User user1 : users)
        //  System.out.println(user1);
    }

    @Test
    public void insertUpdata() throws Exception {
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);


        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        //执行sql语句
        //List<User> users = sqlSession.selectList("test.FindUsername", "王");
        User user = new User();
        user.setId(11);
        user.setUsername("郭德刚shabi");
        user.setBirthday(new Date());
        user.setAddress("低安门l555555555l");
        user.getSex("女");
        int i = sqlSession.update("test.updataById", user);
        sqlSession.commit();
        System.out.println(user.getId());
    }
}
