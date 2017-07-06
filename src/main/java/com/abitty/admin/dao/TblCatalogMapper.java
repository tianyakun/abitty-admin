package com.abitty.admin.dao;

import com.abitty.admin.entity.TblCatalog;

import java.util.List;
import java.util.Map;

public interface TblCatalogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblCatalog record);

    int insertSelective(TblCatalog record);

    TblCatalog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblCatalog record);

    int updateByPrimaryKey(TblCatalog record);

    List<TblCatalog> selectAll();

    TblCatalog selectByCatalogNo(String catalogNo);

    List<TblCatalog> pageQuery(Map<String, Object> paramMap);

    int count(Map<String, Object> paramMap);
}