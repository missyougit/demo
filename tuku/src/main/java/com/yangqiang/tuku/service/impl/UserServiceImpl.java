package com.yangqiang.tuku.service.impl;

import com.yangqiang.tuku.mapper.UserMapper;
import com.yangqiang.tuku.model.*;
import com.yangqiang.tuku.service.UserService;
import com.yangqiang.tuku.utils.Constant;
import com.yangqiang.tuku.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Resource
    private UserMapper userMapper;

    @Override
    public CommonResult getUserByOpenId(String openId) {
        User user = userMapper.getUserByOpenId(openId);
        return new CommonResult(200, "Success", user);
    }

    /**
     * 用户登录
     * @param user
     * @return
     */
    @Override
    public CommonResult logon(User user) {

        String code = user.getCode();
        String url = new StringBuilder()
                .append(Constant.GET_OPEN_ID_URL)
                .append("?appid=")
                .append(Constant.APP_ID)
                .append("&secret=")
                .append(Constant.APP_SECRET)
                .append("&js_code=")
                .append(code)
                .append("&grant_type=")
                .append(Constant.AUTHORIZATION_CODE)
                .toString();

        String openid;
        try {
            OpenidAndSessionKey openidAndSessionKey = restTemplate.getForObject(url, OpenidAndSessionKey.class);
            openid = openidAndSessionKey.getOpenid();
        } catch (Exception e) {
            return new CommonResult(400,"获取openId失败",null);
        }
        User userInfo = userMapper.getUserByOpenId(openid);
        if (userInfo == null){
            user.setOpenId(openid);
            String regdate = DateUtils.getCurrentDate();
            user.setRegdate(regdate);
            int i = userMapper.addUser(user);
            if (i < 1){
                return new CommonResult(400,"登录失败",null);
            }
            return new CommonResult(200,"Success",openid);
        }
        return new CommonResult(200,"Success",openid);

    }

    /**
     * 获取user页面数据
     * @param openId
     * @return
     */
    @Override
    public CommonResult getUserPageData(String openId) {

        UserActionCount userActionCount = userMapper.getUserActionCount("openId",openId);
        User user = userMapper.getUserByOpenId(openId);
        UserPageData userPageData = new UserPageData(user,userActionCount);
        return new CommonResult(200,"Success",userPageData);

    }

}
