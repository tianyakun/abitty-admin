package com.abitty.admin.biz;

/**
 * Created by yak on 17/6/24.
 */
public interface OrderProcessBiz {
    void operateSubOrder(int subOrderId, int status);
}
