package com.abitty.admin.dao;

import com.abitty.BaseTest;
import com.abitty.admin.entity.TblProduct;
import com.abitty.admin.constant.AbittyConstants;
import com.google.common.collect.Maps;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Map;

/**
 * Created by kkk on 17/6/17.
 */
public class TblProductMapperTest extends BaseTest {

    @Autowired
    private TblProductMapper tblProductMapper;

    @Test
    public void testDeleteByPrimaryKey() throws Exception {

    }

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testInsertSelective() throws Exception {
        TblProduct tblProduct = new TblProduct();
        tblProduct.setProductNo("PN0010001");
        tblProduct.setCatalogNo("CN001");
        tblProduct.setProductName("酸奶1");
        tblProduct.setDescription("酸奶1酸奶1");
        tblProduct.setPrice(new BigDecimal("99"));
        tblProduct.setNowPrice(new BigDecimal("88"));
        tblProduct.setStatus(AbittyConstants.ProductState.ON_SALE);
        tblProduct.setIcon("");
        tblProduct.setDetail("酸奶1酸奶1酸奶1酸奶1");
        tblProduct.setImages("");
        tblProduct.setCreateTime(new Date());
        tblProduct.setDeliveryType(AbittyConstants.DeliveryType.WEEKLY);
        tblProductMapper.insertSelective(tblProduct);

        TblProduct tblProduct2 = new TblProduct();
        tblProduct2.setProductNo("PN0020001");
        tblProduct2.setCatalogNo("CN002");
        tblProduct2.setProductName("酸奶2");
        tblProduct2.setDescription("酸奶2酸奶2");
        tblProduct2.setPrice(new BigDecimal("90"));
        tblProduct2.setNowPrice(new BigDecimal("85"));
        tblProduct2.setStatus(AbittyConstants.ProductState.ON_SALE);
        tblProduct2.setIcon("");
        tblProduct2.setDetail("酸奶2酸奶2酸奶2酸奶2");
        tblProduct2.setImages("");
        tblProduct2.setCreateTime(new Date());
        tblProduct2.setDeliveryType(AbittyConstants.DeliveryType.MONTHLY);
        tblProductMapper.insertSelective(tblProduct2);
    }

    @Test
    public void testSelectByPrimaryKey() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKeySelective() throws Exception {

    }

    @Test
    public void testUpdateByPrimaryKey() throws Exception {

    }

    @Test
    public void testSelectAllPublish() throws Exception {

    }

    @Test
    public void testSelectAllPublishByCatalogNo() throws Exception {
        System.out.println(tblProductMapper.selectAllPublishByCatalogNo("CN001"));;
    }

    @Test
    public void testSelectByProductNo() throws Exception {

    }

    @Test
    public void testPageQuery() {
        Map<String, Object> paramMap = Maps.newHashMap();
//        paramMap.put("status", 1);
        paramMap.put("offset", 0);
        paramMap.put("limit", 2);

        System.out.println(tblProductMapper.pageQuery(paramMap));
    }

    @Test
    public void testCount() {
        Map<String, Object> paramMap = Maps.newHashMap();
//        paramMap.put("status", 1);
        paramMap.put("offset", 6);
        paramMap.put("limit", 2);

        System.out.println(tblProductMapper.count(paramMap));
    }

}