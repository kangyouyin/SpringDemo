package com.kyy.springmvc.handler.impl;

import com.kyy.springmvc.handler.UserHandler;
import com.kyy.springmvc.orm.model.UserInfo;
import com.kyy.springmvc.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by kangyouyin on 2018/10/17.
 */
@Component
public class UserHandlerImpl
        implements UserHandler {
    @Autowired
    private UserInfoService userInfoService;

    public List<UserInfo> getUserInfo() {
        List<UserInfo> userInfos = userInfoService.getAllUserInfo();
        return userInfos;
    }
}
