package com.yangqiang.tuku.service.impl;

import com.yangqiang.tuku.mapper.CommentsMapper;
import com.yangqiang.tuku.model.Comments;
import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.service.CommentsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CommentsServiceImpl implements CommentsService {


    @Resource
    private CommentsMapper commentsMapper;

    @Override
    public CommonResult addComments(Comments comments) {

        int i = commentsMapper.addComments(comments);
        return new CommonResult(200, "Success", null);

    }
}
