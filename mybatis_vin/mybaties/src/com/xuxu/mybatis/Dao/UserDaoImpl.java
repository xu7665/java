package com.xuxu.mybatis.Dao;

import com.xuxu.mybatis.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

public class UserDaoImpl implements UserDao {

    private SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory){
        this.sqlSessionFactory = sqlSessionFactory;
    }
    public User selctUserById(Integer id){
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.selectOne("test.findUserById",id);
    }
}
