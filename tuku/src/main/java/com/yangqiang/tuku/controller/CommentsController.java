package com.yangqiang.tuku.controller;

import com.yangqiang.tuku.model.Comments;
import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.service.CommentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("comments")
public class CommentsController {

    @Autowired
    private CommentsService commentsService;

    @PostMapping("/addComments")
    public CommonResult addComments(@RequestBody Comments comments){
        return commentsService.addComments(comments);
    }

    @GetMapping("/getComments")
    public CommonResult getComments(int pageNum, int pageSize,int imagesId) {
        return commentsService.getComments(pageNum,pageSize,imagesId);
    }

}
