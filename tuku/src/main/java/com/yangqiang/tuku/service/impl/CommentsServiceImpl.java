package com.yangqiang.tuku.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.yangqiang.tuku.mapper.CommentsMapper;
import com.yangqiang.tuku.model.Comments;
import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.service.CommentsService;
import com.yangqiang.tuku.utils.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CommentsServiceImpl implements CommentsService {


    @Resource
    private CommentsMapper commentsMapper;

    @Override
    public CommonResult addComments(Comments comments) {

        String currentDate = DateUtils.getCurrentDate();
        comments.setCreateTime(currentDate);
        int i = commentsMapper.addComments(comments);
        return new CommonResult(200, "Success", null);

    }

    @Override
    public CommonResult getComments(int pageNum, int pageSize,int imagesId) {
        PageHelper.startPage(pageNum, pageSize);
        List<Comments> commentsList = commentsMapper.getComments(imagesId);
        PageInfo<Comments> pageInfo = new PageInfo<>(commentsList);
        return new CommonResult(200, "Success", pageInfo);
    }


}
