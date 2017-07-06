package com.abitty.admin.dao;

import com.abitty.BaseTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by kkk on 17/6/26.
 */
public class TblMessageInfoMapperTest extends BaseTest{

    @Autowired
    private TblMessageInfoMapper tblMessageInfoMapper;

    @Test
    public void testSelectByMessageAddress() throws Exception {
        System.out.println(tblMessageInfoMapper.selectByMessageAddress("18610915087"));
    }
}