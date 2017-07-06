package com.abitty.admin.dao;

import com.abitty.admin.entity.TblMessageInfo;

public interface TblMessageInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblMessageInfo record);

    int insertSelective(TblMessageInfo record);

    TblMessageInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblMessageInfo record);

    int updateByPrimaryKey(TblMessageInfo record);

    TblMessageInfo selectByMessageId(String messageId);

    TblMessageInfo selectByMessageAddress(String messageAddress);
}