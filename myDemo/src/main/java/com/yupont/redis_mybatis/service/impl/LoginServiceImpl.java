package com.yupont.redis_mybatis.service.impl;

import com.yupont.mybatis.domain.User;
import com.yupont.redis_mybatis.dao.LoginDao;
import com.yupont.redis_mybatis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/12/25 0025.
 */
@Service
public class LoginServiceImpl implements LoginService {
    @Autowired
    private LoginDao userDao;

    public User loginUser(String userName, String passWord) {
        return userDao.loginUser(userName, passWord);
    }
}
