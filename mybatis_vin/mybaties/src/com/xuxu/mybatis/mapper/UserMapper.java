package com.xuxu.mybatis.mapper;


import com.xuxu.mybatis.User;
import com.xuxu.mybatis.pojo.QueryVo;

import java.util.List;

public interface UserMapper {

    public User findUserById(Integer id);
    public List<User> findUserByQueryVo(QueryVo vo);

    public Integer countUser();

}
