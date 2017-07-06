package com.abitty.admin.service.impl;

import com.abitty.admin.dao.TblCatalogMapper;
import com.abitty.admin.entity.TblCatalog;
import com.abitty.admin.service.CatalogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * Created by yak on 17/6/12.
 */
@Component
public class CatalogServiceImpl implements CatalogService {

    private static final Logger logger = LoggerFactory.getLogger(CatalogServiceImpl.class);

    @Autowired
    private TblCatalogMapper tblCatalogMapper;

    public List<TblCatalog> getAllCatalog() {
        return tblCatalogMapper.selectAll();
    }

    public TblCatalog getByPrimaryKey(Integer id) {
        return tblCatalogMapper.selectByPrimaryKey(id);
    }

    public int update(TblCatalog tblCatalog) {
        return tblCatalogMapper.updateByPrimaryKeySelective(tblCatalog);
    }

    public int add(TblCatalog tblCatalog) {
        return tblCatalogMapper.insertSelective(tblCatalog);
    }

    public TblCatalog getByCatalogNo(String catalogNo) {
        return tblCatalogMapper.selectByCatalogNo(catalogNo);
    }

    @Override
    public List<TblCatalog> pageQuery(Map<String, Object> paramMap) {
        return tblCatalogMapper.pageQuery(paramMap);
    }

    @Override
    public long count(Map<String, Object> paramMap) {
        return tblCatalogMapper.count(paramMap);
    }
}
