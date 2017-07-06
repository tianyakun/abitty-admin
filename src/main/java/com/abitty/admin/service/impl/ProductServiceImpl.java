package com.abitty.admin.service.impl;

import com.abitty.admin.dao.TblProductMapper;
import com.abitty.admin.entity.TblProduct;
import com.abitty.admin.service.ProductService;
import com.google.common.base.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/6/14.
 */
@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private TblProductMapper tblProductMapper;

    @Override
    public TblProduct getByPrimaryKey(Integer integer) {
        return tblProductMapper.selectByPrimaryKey(integer);
    }

    public List<TblProduct> getAllPublish(String catalogNo) {
        if (Strings.isNullOrEmpty(catalogNo)) {
            return tblProductMapper.selectAllPublish();
        } else {
            return tblProductMapper.selectAllPublishByCatalogNo(catalogNo);
        }
    }

    public TblProduct getByProductNo(String productNo) {
        return tblProductMapper.selectByProductNo(productNo);
    }

    @Override
    public List<TblProduct> getAll() {
        return tblProductMapper.selectAll();
    }

    @Override
    public void updateProduct(TblProduct product) {
        tblProductMapper.updateByPrimaryKeySelective(product);
    }

    @Override
    public List<TblProduct> pageQuery(Map<String, Object> paramMap) {
        return tblProductMapper.pageQuery(paramMap);
    }

    @Override
    public int count(Map<String, Object> paramMap) {
        return tblProductMapper.count(paramMap);
    }

    @Override
    public void add(TblProduct tblProduct) {
        tblProductMapper.insertSelective(tblProduct);
    }
}
