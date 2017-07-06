package com.abitty.admin.controller;

import com.abitty.admin.constant.AbittyConstants;
import com.abitty.admin.vo.OrderVo;
import com.abitty.admin.vo.SubOrderVo;
import com.abitty.admin.vo.request.OrderSearchVo;
import com.abitty.admin.biz.OrderProcessBiz;
import com.abitty.admin.entity.TblOrderInfo;
import com.abitty.admin.entity.TblSubOrder;
import com.abitty.admin.service.AddressService;
import com.abitty.admin.service.OrderService;
import com.google.common.base.Function;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.primitives.Ints;
import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/7/4.
 */
@Controller
@RequestMapping(value = "/order")
public class OrderController {

    private final static Logger logger = LoggerFactory.getLogger(OrderController.class);

    private final static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    @Autowired
    private OrderProcessBiz orderProcessBiz;

    @Autowired
    private OrderService orderService;

    @Autowired
    private AddressService addressService;

    @RequestMapping(value = "/list")
    public ModelAndView list(OrderSearchVo vo, Model model) {
        logger.info("获取订单列表请求 {}", vo);

        Map<String, Object> paramMap = getQueryParamMap(vo);

        List<TblOrderInfo> tblOrderInfoList = orderService.pageQuery(paramMap);

        List<OrderVo> orderVoList = buildOrderVoList(tblOrderInfoList);

        long totalCount = orderService.count(paramMap);

        logger.info("获取订单列表查询返回: orderVoList={}, totalCount={}", orderVoList, totalCount);

        model.addAttribute("orderVoList", orderVoList);

        model.addAttribute("totalCount", totalCount);
        model.addAttribute("pageSize", vo.getPageSize());

        model.addAttribute("orderNo", vo.getOrderNo());
        model.addAttribute("status", vo.getStatus());
        model.addAttribute("startDate", vo.getStartDate());
        model.addAttribute("endDate", vo.getEndDate());

        return new ModelAndView("order/list");
    }

    @RequestMapping(value = "/detail/{id}")
    public ModelAndView detail(@PathVariable("id") final String id, Model model) {
        logger.info("获取订单详情请求 id = {}", id);

        TblOrderInfo tblOrderInfo = orderService.getByPrimaryKey(Ints.tryParse(id));

        OrderVo orderVo = buildOrderVo(tblOrderInfo);

        logger.info("获取订单详情返回: order={}", orderVo);

        model.addAttribute("order", orderVo);

        return new ModelAndView("order/detail");
    }

    @RequestMapping(value = "/sub/update/{orderId}/{subId}/{status}")
    public ModelAndView update(@PathVariable("orderId") final int orderId, @PathVariable("subId") final int subId, @PathVariable("status") final int status, Model model) {
        logger.info("子订单状态修改请求 orderId={} subId={} status={}", orderId, subId, status);

        orderProcessBiz.operateSubOrder(subId, status);

        return new ModelAndView("redirect:/order/detail/" + orderId);
    }

    private Map<String, Object> getQueryParamMap(OrderSearchVo vo) {
        Map<String, Object> paramMap = Maps.newHashMap();
        if (!Strings.isNullOrEmpty(vo.getOrderNo())) {
            paramMap.put("orderNo", vo.getOrderNo());
        }
        if (!Strings.isNullOrEmpty(vo.getStatus()) || Ints.tryParse(vo.getStatus()) != null) {
            paramMap.put("status", Ints.tryParse(vo.getStatus()));
        }
        if (!Strings.isNullOrEmpty(vo.getStartDate())) {
            try {
                paramMap.put("startDate", dateFormat.parse(vo.getStartDate()));
            } catch (ParseException e) {
                logger.error("startDate转换错误", e);
            }
        }
        if (!Strings.isNullOrEmpty(vo.getEndDate())) {
            try {
                paramMap.put("endDate", dateFormat.parse(vo.getEndDate()));
            } catch (ParseException e) {
                logger.error("endDate转换错误", e);
            }
        }

        paramMap.put("offset", vo.getStartIndex());
        paramMap.put("limit", vo.getPageSize());

        return paramMap;
    }

    private List<OrderVo> buildOrderVoList(List<TblOrderInfo> tblOrderInfoList) {
        if (CollectionUtils.isEmpty(tblOrderInfoList)) {
            return Lists.newArrayList();
        }

        return Lists.transform(tblOrderInfoList, new Function<TblOrderInfo, OrderVo>() {
            @Override
            public OrderVo apply(TblOrderInfo input) {
                return buildOrderVo(input);
            }
        });
    }

    private OrderVo buildOrderVo(TblOrderInfo input) {
        if (input == null) {
            return null;
        }

        OrderVo vo = new OrderVo();
        vo.setId(input.getId());
        vo.setOrderNo(input.getOrderNo());
        vo.setUid(input.getUid());
        vo.setProductNo(input.getProductNo());
        vo.setServiceAtomCount(input.getServiceAtomCount());
        vo.setTotalQuantity(input.getTotalQuantity());
        vo.setTotalAmount(input.getTotalAmount());
        vo.setStatus(input.getStatus());
        vo.setPayId(input.getPayId());
        vo.setPayReturnId(input.getPayReturnId());
        vo.setDeliveryType(input.getDeliveryType());
        vo.setDeliveryTime(input.getDeliveryTime());
        vo.setSubQuantity(input.getSubQuantity());
        vo.setTotalSub(input.getTotalSub());
        vo.setFinishSub(input.getFinishSub());
        vo.setNextSub(input.getNextSub());
        if (input.getNextSubTime() == null) {
            vo.setNextSubTime("");
        } else {
            vo.setNextSubTime(AbittyConstants.DATETIME_FORMAT.format(input.getNextSubTime()));
        }
        vo.setAddressId(input.getAddressId());
        vo.setUserNumber(input.getUserNumber());
        vo.setRemark(input.getRemark());
        vo.setErrorCode(input.getErrorCode());
        vo.setErrorMsg(input.getErrorMsg());
        if (input.getCreateTime() == null) {
            vo.setCreateTime("");
        } else {
            vo.setCreateTime(AbittyConstants.DATETIME_FORMAT.format(input.getCreateTime()));
        }

        if (CollectionUtils.isNotEmpty(input.getSubOrderList())) {
            List<SubOrderVo> subOrderVoList = buildSubVoList(input.getSubOrderList());
            vo.setSubOrderVoList(subOrderVoList);
        }

        return vo;

    }

    private List<SubOrderVo> buildSubVoList(List<TblSubOrder> subOrderList) {
        if (CollectionUtils.isEmpty(subOrderList)) {
            return Lists.newArrayList();
        }

        return Lists.transform(subOrderList, new Function<TblSubOrder, SubOrderVo>() {
            @Override
            public SubOrderVo apply(TblSubOrder input) {
                if (input == null) {
                    return null;
                }

                SubOrderVo vo = new SubOrderVo();
                vo.setId(input.getId());
                vo.setSubOrderNo(input.getSubOrderNo());
                vo.setOrderNo(input.getOrderNo());
                vo.setProductNo(input.getProductNo());
                vo.setQuantity(input.getQuantity());
                vo.setStatus(input.getStatus());
                vo.setRecvName(input.getRecvName());
                vo.setPhone(input.getPhone());
                vo.setAddress(input.getAddress());
                if (input.getDeliveryTime() == null) {
                    vo.setDeliveryTime("");
                } else {
                    vo.setDeliveryTime(AbittyConstants.DATETIME_FORMAT.format(input.getDeliveryTime()));
                }
                vo.setUsedPercent(input.getUsedPercent());
                vo.setRemark(input.getRemark());
                if (input.getCreateTime() == null) {
                    vo.setCreateTime("");
                } else {
                    vo.setCreateTime(AbittyConstants.DATETIME_FORMAT.format(input.getCreateTime()));
                }
                return vo;
            }
        });
    }


}
