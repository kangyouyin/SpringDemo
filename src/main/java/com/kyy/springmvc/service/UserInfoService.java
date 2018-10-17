package com.kyy.springmvc.service;

import com.kyy.springmvc.orm.mapper.UserInfoMapper;
import com.kyy.springmvc.orm.model.UserInfo;
import com.kyy.springmvc.orm.model.UserInfoExample;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by kangyouyin on 2018/10/16.
 */
@Service
public class UserInfoService {

    @Autowired
    UserInfoMapper userInfoMapper;

    public List<UserInfo> getAllUserInfo() {
        UserInfoExample example = new UserInfoExample();
        return userInfoMapper.selectByExample(example);
    }
}
