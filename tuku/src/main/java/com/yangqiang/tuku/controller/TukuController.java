package com.yangqiang.tuku.controller;


import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.service.TukuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("image")
public class TukuController {

    @Autowired
    private TukuService tukuService;

    @GetMapping("/list")
    public CommonResult getImages(int pageNum, int pageSize, String openId){
        return tukuService.getImages(pageNum,pageSize, openId);
    }




}
