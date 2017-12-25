package com.yupont.mybatis.service;

import com.yupont.mybatis.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public interface UserService {
    public User queryUserByName(String userName);

    public List<User> queryAllUser();
}
