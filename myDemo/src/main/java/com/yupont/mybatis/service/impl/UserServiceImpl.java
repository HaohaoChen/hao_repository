package com.yupont.mybatis.service.impl;

import com.yupont.mybatis.dao.UserDao;
import com.yupont.mybatis.domain.User;
import com.yupont.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */

@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UserDao userDao;

    public User queryUserByName(String userName) {
        return userDao.queryUserByName(userName);
    }

    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }
}
