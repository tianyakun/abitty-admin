package com.abitty.admin.service;

import com.abitty.admin.entity.TblAddress;
import com.abitty.admin.entity.TblOrderInfo;

import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/6/16.
 */
public interface OrderService {
    void add(TblOrderInfo tblOrderInfo);

    List<TblOrderInfo> getAllByUid(String uid);

    TblOrderInfo queryOrderInfo(String orderNo);

    boolean saveRequestOrder(TblOrderInfo tblOrderInfo, TblAddress tblAddress);

    void recievePayinfo(TblOrderInfo tblOrderInfo);

    TblOrderInfo getByPayId(String payId);

    boolean paySuccess(TblOrderInfo tblOrderInfo);

    List<TblOrderInfo> getSuccessOrderByUid(String uid);

    List<TblOrderInfo> pageQuery(Map<String, Object> paramMap);

    long count(Map<String, Object> paramMap);

    TblOrderInfo getByPrimaryKey(Integer integer);

    void operateSubOrder(int subOrderId, int status);
}
