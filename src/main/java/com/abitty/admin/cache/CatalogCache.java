package com.abitty.admin.cache;

import com.abitty.admin.entity.TblCatalog;
import com.abitty.admin.service.CatalogService;
import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by yak on 17/7/2.
 */
@Component
public class CatalogCache {

    @Autowired
    private CatalogService catalogService;

    private Map<String, TblCatalog> allCatalogMap = new ConcurrentHashMap<>();

    private Map<String, TblCatalog> catalogMap = new ConcurrentHashMap<>();

    @PostConstruct
    public void init() {
        List<TblCatalog> catalogList = catalogService.getAllCatalog();

        allCatalogMap.clear();
        catalogMap.clear();

        for (TblCatalog tblCatalog : catalogList) {
            allCatalogMap.put(tblCatalog.getCatalogNo(), tblCatalog);

            if (tblCatalog.getIsDelete() == 0) {
                catalogMap.put(tblCatalog.getCatalogNo(), tblCatalog);
            }
        }
    }

    public List<TblCatalog> getAllCatalogList() {
        return Lists.newArrayList(allCatalogMap.values());
    }

    public List<TblCatalog> getCatalogList() {
        return Lists.newArrayList(catalogMap.values());
    }

    public TblCatalog getCatalog(String catalogNo) {
        return allCatalogMap.get(catalogNo);
    }

}
