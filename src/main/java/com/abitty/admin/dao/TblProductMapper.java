package com.abitty.admin.dao;

import com.abitty.admin.entity.TblProduct;

import java.util.List;
import java.util.Map;

public interface TblProductMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblProduct record);

    int insertSelective(TblProduct record);

    TblProduct selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblProduct record);

    int updateByPrimaryKey(TblProduct record);

    List<TblProduct> selectAllPublish();

    List<TblProduct> selectAllPublishByCatalogNo(String catalogNo);

    TblProduct selectByProductNo(String productNo);

    List<TblProduct> selectAll();

    List<TblProduct> pageQuery(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);
}