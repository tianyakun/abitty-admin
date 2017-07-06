package com.abitty.admin.service.impl;

import com.abitty.admin.dao.TblFeedbackMapper;
import com.abitty.admin.entity.TblFeedback;
import com.abitty.admin.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by yak on 17/6/28.
 */
@Component
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    private TblFeedbackMapper tblFeedbackMapper;

    @Override
    public void addFeedback(TblFeedback tblFeedback) {
        tblFeedbackMapper.insertSelective(tblFeedback);
    }
}
