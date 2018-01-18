package com.xuxu.mybatis.juit;

import com.xuxu.mybatis.Dao.UserDaoImpl;
import com.xuxu.mybatis.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;
import com.xuxu.mybatis.Dao.*;

import java.io.InputStream;

public class MybatisDaoTest {

    private SqlSessionFactory sqlSessionFactory;

    @Before
    public void before() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);


        sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);


    }

    @Test
    public void testDao() throws Exception{
        UserDaoImpl userDao = new UserDaoImpl(sqlSessionFactory);
        User user = userDao.selctUserById(11);
        System.out.println(user);
    }
}
