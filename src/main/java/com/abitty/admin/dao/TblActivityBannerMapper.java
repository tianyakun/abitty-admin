package com.abitty.admin.dao;

import com.abitty.admin.entity.TblActivityBanner;

import java.util.List;

public interface TblActivityBannerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TblActivityBanner record);

    int insertSelective(TblActivityBanner record);

    TblActivityBanner selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TblActivityBanner record);

    int updateByPrimaryKey(TblActivityBanner record);

    List<TblActivityBanner> selectAllEffective();
}