package com.xuxu.mybatis.mapper;

import com.xuxu.mybatis.pojo.Orders;

import java.util.List;

public interface OrderMapper {

    public List<Orders> selectOrderList();
}
