package com.abitty.admin.dao;

import com.abitty.admin.entity.TblUser;

public interface TblUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    TblUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);

    TblUser selectByUid(String uid);
}