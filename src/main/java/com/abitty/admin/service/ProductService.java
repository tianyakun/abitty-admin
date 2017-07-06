package com.abitty.admin.service;

import com.abitty.admin.entity.TblProduct;

import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/6/14.
 */
public interface ProductService {
    List<TblProduct> getAllPublish(String catalogNo);

    TblProduct getByProductNo(String productNo);

    List<TblProduct> getAll();

    TblProduct getByPrimaryKey(Integer integer);

    void updateProduct(TblProduct product);

    List<TblProduct> pageQuery(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);

    void add(TblProduct tblProduct);
}
