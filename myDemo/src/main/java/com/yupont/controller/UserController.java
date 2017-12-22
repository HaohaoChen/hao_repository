package com.yupont.controller;

import com.yupont.domain.User;
import com.yupont.service.UserService;
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

    @RequestMapping(value = "/login/loginUser", method = RequestMethod.GET)
    public User loginUser(@RequestParam(value = "userName", required = true) String userName ,
                          @RequestParam(value = "passWord", required = true) String passWord){
        return  userService.loginUser(userName,passWord);
    }

    @RequestMapping(value = "/login/queryAllUser", method = RequestMethod.GET)
    public List<User> loginUser(){
        return  userService.queryAllUser();
    }
}
