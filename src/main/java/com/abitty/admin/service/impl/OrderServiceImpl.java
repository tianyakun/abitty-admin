package com.abitty.admin.service.impl;

import com.abitty.admin.dao.TblAddressMapper;
import com.abitty.admin.dao.TblOrderInfoMapper;
import com.abitty.admin.dao.TblSubOrderMapper;
import com.abitty.admin.entity.TblAddress;
import com.abitty.admin.entity.TblOrderInfo;
import com.abitty.admin.entity.TblSubOrder;
import com.abitty.admin.service.OrderService;
import com.abitty.admin.constant.AbittyConstants;
import com.abitty.admin.utils.DateUtils;
import com.abitty.admin.utils.Sequence;
import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/6/16.
 */
@Component
public class OrderServiceImpl implements OrderService{

    private final static Logger logger = LoggerFactory.getLogger(OrderServiceImpl.class);

    @Autowired
    private TblOrderInfoMapper tblOrderInfoMapper;

    @Autowired
    private TblAddressMapper tblAddressMapper;

    @Autowired
    private TblSubOrderMapper tblSubOrderMapper;

    public void add(TblOrderInfo tblOrderInfo) {
        tblOrderInfoMapper.insertSelective(tblOrderInfo);
    }

    @Transactional
    public boolean paySuccess(TblOrderInfo tblOrderInfo) {

        try {
            Preconditions.checkNotNull(tblOrderInfo, "tblOrderInfo is null");

            List<TblSubOrder> subOrderList = buildSubOrders(tblOrderInfo);
            for (TblSubOrder tblSubOrder : subOrderList) {
                tblSubOrderMapper.insertSelective(tblSubOrder);
            }

            TblSubOrder firstSubOrder = subOrderList.get(0);
            tblOrderInfo.setStatus(AbittyConstants.OrderState.PAY_SUCCESS);
            tblOrderInfo.setNextSub(firstSubOrder.getSubOrderNo());
            tblOrderInfo.setNextSubTime(firstSubOrder.getDeliveryTime());
            tblOrderInfoMapper.updateByPrimaryKeySelective(tblOrderInfo);

            return true;
        } catch (Exception e) {
            logger.error("订单支付成功 更新失败", e);
            return false;
        }


    }

    public List<TblOrderInfo> getAllByUid(String uid) {

        return tblOrderInfoMapper.selectByUid(uid);
    }

    public TblOrderInfo queryOrderInfo(String orderNo) {

        TblOrderInfo tblOrderInfo = tblOrderInfoMapper.selectByOrderNo(orderNo);

        if (tblOrderInfo != null) {
            List<TblSubOrder> subOrderList = tblSubOrderMapper.selectByOrderNo(orderNo);
            tblOrderInfo.setSubOrderList(subOrderList);
        }

        return tblOrderInfo;

    }

    private List<TblSubOrder> buildSubOrders(TblOrderInfo tblOrderInfo) {
        List<TblSubOrder> tblSubOrderList = Lists.newArrayList();

        String orderNo = tblOrderInfo.getOrderNo();
        String productNo = tblOrderInfo.getProductNo();
        int quantity = tblOrderInfo.getSubQuantity();
        TblAddress tblAddress = tblAddressMapper.selectByPrimaryKey(tblOrderInfo.getAddressId());
        String recName = tblAddress.getRecName();
        String phone = tblAddress.getPhone();
        String address = tblAddress.getPcaDetail() + tblAddress.getAddressDetail();

        Date createTime = tblOrderInfo.getCreateTime();
        Date first = DateUtils.addDays(createTime, 3);

        for (int i = 0; i < tblOrderInfo.getTotalSub(); i++) {
            TblSubOrder tblSubOrder = new TblSubOrder();
            tblSubOrder.setSubOrderNo("sub" + Sequence.next());
            tblSubOrder.setOrderNo(orderNo);
            tblSubOrder.setProductNo(productNo);
            tblSubOrder.setQuantity(quantity);
            tblSubOrder.setStatus(AbittyConstants.SubOrderState.INITIAL);
            tblSubOrder.setRecvName(recName);
            tblSubOrder.setPhone(phone);
            tblSubOrder.setAddress(address);
            tblSubOrder.setCreateTime(new Date());

            tblSubOrder.setDeliveryTime(DateUtils.addWeeks(first, i));

            tblSubOrderList.add(tblSubOrder);
        }

        return tblSubOrderList;
    }

    @Transactional
    @Override
    public boolean saveRequestOrder(TblOrderInfo tblOrderInfo, TblAddress tblAddress) {


        tblAddressMapper.insertSelective(tblAddress);

        tblOrderInfo.setAddressId(tblAddress.getId());
        tblOrderInfoMapper.insertSelective(tblOrderInfo);

        return true;
    }

    @Override
    public void recievePayinfo(TblOrderInfo tblOrderInfo) {
        tblOrderInfoMapper.updateByPrimaryKeySelective(tblOrderInfo);
    }

    @Override
    public TblOrderInfo getByPayId(String payId) {
        return tblOrderInfoMapper.selectByPayId(payId);
    }

    @Override
    public List<TblOrderInfo> getSuccessOrderByUid(String uid) {
        return tblOrderInfoMapper.selectSuccessOrderByUid(uid);
    }

    @Override
    public List<TblOrderInfo> pageQuery(Map<String, Object> paramMap) {
        return tblOrderInfoMapper.pageQuery(paramMap);
    }

    @Override
    public long count(Map<String, Object> paramMap) {
        return tblOrderInfoMapper.count(paramMap);
    }

    @Override
    public TblOrderInfo getByPrimaryKey(Integer id) {
        TblOrderInfo tblOrderInfo = tblOrderInfoMapper.selectByPrimaryKey(id);

        if (tblOrderInfo != null) {
            List<TblSubOrder> subOrderList = tblSubOrderMapper.selectByOrderNo(tblOrderInfo.getOrderNo());
            tblOrderInfo.setSubOrderList(subOrderList);
        }

        return tblOrderInfo;
    }

    @Override
    @Transactional
    public void operateSubOrder(int subOrderId, int status) {
        TblSubOrder tblSubOrder = tblSubOrderMapper.selectByPrimaryKey(subOrderId);
        if (tblSubOrder!=null) {
            tblSubOrder.setStatus(status);
            tblSubOrderMapper.updateByPrimaryKeySelective(tblSubOrder);

            TblOrderInfo tblOrderInfo = tblOrderInfoMapper.selectByOrderNo(tblSubOrder.getOrderNo());

            if (status == AbittyConstants.SubOrderState.READY
                    && tblOrderInfo.getStatus() == AbittyConstants.OrderState.PAY_SUCCESS) {
                tblOrderInfo.setStatus(AbittyConstants.OrderState.SERVING);
            }

            if (status == AbittyConstants.SubOrderState.ARRIVED) {
                tblOrderInfo.setFinishSub(tblOrderInfo.getFinishSub() + 1);

                if (tblOrderInfo.getFinishSub() == tblOrderInfo.getTotalSub()) {
                    tblOrderInfo.setStatus(AbittyConstants.OrderState.FINISH);
                    tblOrderInfo.setNextSub("");
                } else {
                    List<TblSubOrder> subOrderList = tblSubOrderMapper.selectByOrderNo(tblSubOrder.getOrderNo());
                    for (TblSubOrder subOrder : subOrderList) {
                        if (subOrder.getDeliveryTime().after(tblSubOrder.getDeliveryTime())) {
                            tblOrderInfo.setNextSub(subOrder.getSubOrderNo());
                            tblOrderInfo.setNextSubTime(subOrder.getDeliveryTime());
                            break;
                        }
                    }
                }

                tblOrderInfoMapper.updateByPrimaryKey(tblOrderInfo);
            }
        }


    }
}
