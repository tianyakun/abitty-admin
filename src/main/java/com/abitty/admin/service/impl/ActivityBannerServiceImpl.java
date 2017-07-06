package com.abitty.admin.service.impl;

import com.abitty.admin.dao.TblActivityBannerMapper;
import com.abitty.admin.entity.TblActivityBanner;
import com.abitty.admin.service.ActivityBannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by yak on 17/6/29.
 */
@Component
public class ActivityBannerServiceImpl implements ActivityBannerService {

    @Autowired
    private TblActivityBannerMapper tblActivityBannerMapper;

    @Override
    public List<TblActivityBanner> getAllEffective() {
        return tblActivityBannerMapper.selectAllEffective();
    }
}
