package com.abitty.admin.dao;

import com.abitty.BaseTest;
import com.abitty.admin.constant.AbittyConstants;
import com.abitty.admin.entity.TblOrderInfo;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.text.ParseException;
import java.util.List;
import java.util.Map;

/**
 * Created by kkk on 17/6/28.
 */
public class TblOrderInfoMapperTest extends BaseTest{

    @Autowired
    private TblOrderInfoMapper tblOrderInfoMapper;

    @Test
    public void testSelectSuccessOrderByUid() throws Exception {
        System.out.println(tblOrderInfoMapper.selectSuccessOrderByUid("18610915087"));
    }

    @Test
    public void testPageQuery() throws ParseException {
        Map<String, Object> paramMap = Maps.newHashMap();
//        paramMap.put("orderNo", "O330524117931393024");
//        paramMap.put("status", 1);
        paramMap.put("startDate", AbittyConstants.DATETIME_FORMAT.parse("2017-07-03 00:00:00"));
        paramMap.put("endDate", AbittyConstants.DATETIME_FORMAT.parse("2017-07-04 00:00:00"));

        List<TblOrderInfo> list = tblOrderInfoMapper.pageQuery(paramMap);

        System.out.println(list.size());
        System.out.println(list);
    }
}