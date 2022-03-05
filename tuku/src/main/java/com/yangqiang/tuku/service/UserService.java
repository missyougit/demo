package com.yangqiang.tuku.service;

import com.yangqiang.tuku.model.CommonResult;
import com.yangqiang.tuku.model.User;

public interface UserService {

    CommonResult getUserByOpenId(String openId);

    CommonResult logon(User user);

    CommonResult getUserPageData(String openId);
}
