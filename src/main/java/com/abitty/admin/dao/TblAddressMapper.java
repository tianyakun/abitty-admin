package com.abitty.admin.dao;

import com.abitty.admin.entity.TblAddress;

import java.util.List;

public interface TblAddressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblAddress record);

    int insertSelective(TblAddress record);

    TblAddress selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblAddress record);

    int updateByPrimaryKey(TblAddress record);

    List<TblAddress> selectAllByUid(String uid);
}