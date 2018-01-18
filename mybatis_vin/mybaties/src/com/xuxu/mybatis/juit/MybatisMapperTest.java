package com.xuxu.mybatis.juit;

import com.xuxu.mybatis.User;
import com.xuxu.mybatis.mapper.OrderMapper;
import com.xuxu.mybatis.mapper.UserMapper;
import com.xuxu.mybatis.pojo.Orders;
import com.xuxu.mybatis.pojo.QueryVo;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.InputStream;
import java.util.List;

public class MybatisMapperTest {

    @Test
    public void testMapper() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.findUserById(11);
        System.out.println(userById);
    }
    @Test
    public void testMapperQueryVo() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
       // User userById = mapper.findUserById(11);
        QueryVo vo = new QueryVo();
        User user = new User();
        user.setUsername("刘");
        vo.setUser(user);

        List<User> us = userMapper.findUserByQueryVo(vo);
        for (User user1 : us){
            System.out.println(user1);
        }

    }
    @Test
    public void testMapperQueryVoCount() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        // User userById = mapper.findUserById(11);


        //List<User> us = userMapper.findUserByQueryVo(vo);
        Integer i = userMapper.countUser();
        System.out.println(i);

    }
    @Test
    public void testMapperOrder() throws Exception{
        String resource = "sqlMapConfig.xml";
        InputStream in = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(in);
        SqlSession sqlSession = sqlSessionFactory.openSession();

        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        List<Orders> ordersList = orderMapper.selectOrderList();
        for (Orders or : ordersList){
            System.out.println(or);
        }
    }

}
