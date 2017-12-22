package com.yupont.service;

import com.yupont.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface UserService {
    public User loginUser(String userName,String passWord);

    public List<User> queryAllUser();
}
