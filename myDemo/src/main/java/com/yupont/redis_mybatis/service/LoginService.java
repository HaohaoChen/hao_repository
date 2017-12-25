package com.yupont.redis_mybatis.service;

import com.yupont.mybatis.domain.User;

/**
 * Created by Administrator on 2017/12/25 0025.
 */
public interface LoginService {
    public User loginUser(String userName, String passWord);
}
