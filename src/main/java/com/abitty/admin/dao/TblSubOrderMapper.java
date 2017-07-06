package com.abitty.admin.dao;

import com.abitty.admin.entity.TblSubOrder;

import java.util.List;

public interface TblSubOrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblSubOrder record);

    int insertSelective(TblSubOrder record);

    TblSubOrder selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblSubOrder record);

    int updateByPrimaryKey(TblSubOrder record);

    List<TblSubOrder> selectByOrderNo(String orderNo);
}