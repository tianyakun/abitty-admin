package com.abitty.admin.service;

import com.abitty.admin.entity.TblCatalog;

import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/6/12.
 */
public interface CatalogService {

    public List<TblCatalog> getAllCatalog();

    public TblCatalog getByPrimaryKey(Integer id);

    public int update(TblCatalog tblCatalog);

    public int add(TblCatalog tblCatalog);

    TblCatalog getByCatalogNo(String catalogNo);

    List<TblCatalog> pageQuery(Map<String, Object> paramMap);

    long count(Map<String, Object> paramMap);
}
