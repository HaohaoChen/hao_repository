package com.yupont.redis_mybatis.controller;

import com.yupont.mybatis.domain.User;
import com.yupont.redis_mybatis.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
@RestController
public class LoginController {
    @Autowired
    private LoginService loginService;

    @RequestMapping(value = "/login/loginUser", method = RequestMethod.GET)
    public User loginUser(@RequestParam(value = "userName", required = true) String userName ,
                          @RequestParam(value = "passWord", required = true) String passWord){
        return  loginService.loginUser(userName,passWord);
    }

    @RequestMapping(value = "/login/updateUser", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user) {
        loginService.updateUser(user);
    }

    @RequestMapping(value = "/login/deleteUser/{name}", method = RequestMethod.DELETE)
    public void deleteUser(@PathVariable("name") String name ){
        loginService.deleteUser(name);
    }
}
