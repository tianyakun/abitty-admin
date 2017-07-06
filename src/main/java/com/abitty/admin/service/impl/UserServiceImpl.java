package com.abitty.admin.service.impl;

import com.abitty.admin.dao.TblUserMapper;
import com.abitty.admin.entity.TblUser;
import com.abitty.admin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yak on 17/6/17.
 */
@Component
public class UserServiceImpl implements UserService {

    @Autowired
    private TblUserMapper tblUserMapper;

    public TblUser getUserByUid(String uid) {
        return tblUserMapper.selectByUid(uid);
    }

    public int update(TblUser tblUser) {
        return tblUserMapper.updateByPrimaryKeySelective(tblUser);
    }

    public int add(TblUser tblUser) {
        return tblUserMapper.insertSelective(tblUser);
    }
}
