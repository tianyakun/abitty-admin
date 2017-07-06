package com.abitty.admin.dao;

import com.abitty.BaseTest;
import com.abitty.admin.constant.AbittyConstants;
import com.abitty.admin.entity.TblCatalog;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * Created by kkk on 17/6/12.
 */
public class TblCatalogMapperTest extends BaseTest {

    @Autowired
    private TblCatalogMapper tblCatalogMapper;

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {
        TblCatalog tblCatalog = new TblCatalog();
        tblCatalog.setCatalogNo("CN" + System.currentTimeMillis());
        tblCatalog.setName("酸奶");
        tblCatalog.setDeliveryType(AbittyConstants.DeliveryType.WEEKLY);
        tblCatalog.setCreateTime(new Date());
        tblCatalogMapper.insertSelective(tblCatalog);

        TblCatalog tblCatalog2 = new TblCatalog();
        tblCatalog2.setCatalogNo("CN" + System.currentTimeMillis());
        tblCatalog2.setName("抽纸");
        tblCatalog2.setCreateTime(new Date());
        tblCatalog2.setDeliveryType(AbittyConstants.DeliveryType.MONTHLY);
        tblCatalogMapper.insertSelective(tblCatalog2);
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {
        System.out.println(tblCatalogMapper.selectByPrimaryKey(1));
    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }

    @Test
    public void testSelectAll() throws Exception {
        System.out.println(tblCatalogMapper.selectAll());
    }

    @Test
    public void testPageQuery() {
        Map<String, Object> paramMap = Maps.newHashMap();

//        paramMap.put("isDelete", 0);

        paramMap.put("offset", 1);
        paramMap.put("limit", 3);
        List<TblCatalog> list = tblCatalogMapper.pageQuery(paramMap);
        System.out.println(list.size());
        System.out.println(list);
    }

    @Test
    public void testCount() {
        Map<String, Object> paramMap = Maps.newHashMap();

//        paramMap.put("isDelete", 0);

        System.out.println(tblCatalogMapper.count(paramMap));
    }

}