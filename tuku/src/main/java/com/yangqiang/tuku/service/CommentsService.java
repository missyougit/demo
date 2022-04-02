package com.yangqiang.tuku.service;

import com.yangqiang.tuku.model.Comments;
import com.yangqiang.tuku.model.CommonResult;

public interface CommentsService {

    //添加评论/回复
    CommonResult addComments(Comments comments);

    //通过imagesId分页查询评论
    CommonResult getComments(int pageNum, int pageSize,int imagesId);


}
