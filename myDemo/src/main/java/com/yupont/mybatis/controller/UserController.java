package com.yupont.mybatis.controller;

import com.yupont.mybatis.domain.User;
import com.yupont.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping(value = "/user/queryUserByName", method = RequestMethod.GET)
    public User queryUserByName(@RequestParam(value = "userName", required = true) String userName){
        return  userService.queryUserByName(userName);
    }

    @RequestMapping(value = "/user/queryAllUser", method = RequestMethod.GET)
    public List<User> loginUser(){
        return  userService.queryAllUser();
    }
}
