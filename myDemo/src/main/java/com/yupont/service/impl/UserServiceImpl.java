package com.yupont.service.impl;

import com.yupont.dao.UserDao;
import com.yupont.domain.User;
import com.yupont.service.UserService;
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

    public User loginUser(String userName, String passWord) {
        return userDao.loginUser(userName, passWord);
    }

    public List<User> queryAllUser() {
        return userDao.queryAllUser();
    }
}
