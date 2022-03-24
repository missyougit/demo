package com.yangqiang.tuku.controller;

import com.yangqiang.tuku.model.Comments;
import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("/addComments")
    public CommonResult addComments(@RequestBody Comments comments){
        return commentsService.addComments(comments);
    }



}
