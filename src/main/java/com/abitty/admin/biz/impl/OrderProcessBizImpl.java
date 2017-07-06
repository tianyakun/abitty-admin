package com.abitty.admin.biz.impl;

import com.abitty.admin.biz.OrderProcessBiz;
import com.abitty.admin.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yak on 17/6/24.
 */
@Component
public class OrderProcessBizImpl implements OrderProcessBiz {

    private final static Logger logger = LoggerFactory.getLogger(OrderProcessBizImpl.class);

    @Autowired
    private OrderService orderService;

    @Override
    public void operateSubOrder(int subOrderId, int status) {
        orderService.operateSubOrder(subOrderId, status);
    }

}
