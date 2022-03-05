package com.yangqiang.tuku.controller;

import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.model.User;
import com.yangqiang.tuku.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/userInfo")
    public CommonResult getUserByOpenId(String openId){
        return userService.getUserByOpenId(openId);
    }


    @PostMapping("/logon")
    public CommonResult logon(@RequestBody User user){
        return userService.logon(user);
    }

    /**
     * 获取use页面数据
     * @param openId
     * @return
     */
    @GetMapping("/userPageData")
    public CommonResult getUserPageData(String openId){
        return userService.getUserPageData(openId);
    }

}
