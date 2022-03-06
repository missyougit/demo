package com.yangqiang.tuku.service.impl;

import com.yangqiang.tuku.mapper.UserActionMapper;
import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.model.UserAction;
import com.yangqiang.tuku.service.UserActionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserActionServiceImpl implements UserActionService {

    @Resource
    private UserActionMapper userActionMapper;


    /**
     * 点赞和分享都是用此方法
     * @param userAction
     * @return
     */
    @Override
    public CommonResult thumbsUp(UserAction userAction) {

        int imagesId = userAction.getImagesId();
        String openId = userAction.getOpenId();
        UserAction action = userActionMapper.getUserAction(imagesId, openId,0);
        if(null == action) {
            userActionMapper.addUserAction(userAction);
        }else {
            userActionMapper.thumbsUp(userAction);
        }
        return null;

    }


}
