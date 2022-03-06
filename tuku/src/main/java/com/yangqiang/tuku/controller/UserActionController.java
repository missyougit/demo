package com.yangqiang.tuku.controller;

import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.model.UserAction;
import com.yangqiang.tuku.service.UserActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("userAction")
public class UserActionController {

    @Autowired
    private UserActionService userActionService;

    @PutMapping("/thumbsUp")
    public CommonResult thumbsUp(@RequestBody UserAction userAction){
        return userActionService.thumbsUp(userAction);
    }


}
