package com.abitty.admin.dao;

import com.abitty.admin.entity.TblOrderInfo;

import java.util.List;
import java.util.Map;

public interface TblOrderInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblOrderInfo record);

    int insertSelective(TblOrderInfo record);

    TblOrderInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblOrderInfo record);

    int updateByPrimaryKey(TblOrderInfo record);

    TblOrderInfo selectByOrderNo(String orderNo);

    List<TblOrderInfo> selectByUid(String uid);

    TblOrderInfo selectByPayId(String payId);

    List<TblOrderInfo> selectSuccessOrderByUid(String uid);

    List<TblOrderInfo> pageQuery(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);
}