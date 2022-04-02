package com.yangqiang.tuku.service;


import com.yangqiang.tuku.model.CommonResult;

public interface TukuService {

    //获取图片
    CommonResult getImages(int pageNum, int pageSize, String openId);


}
