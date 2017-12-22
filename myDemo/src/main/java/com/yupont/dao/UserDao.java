package com.yupont.dao;

import com.yupont.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by Administrator on 2017/12/21 0021.
 */

public interface UserDao {
    //@Param("userName") 对应UserMapper.xml中传递的参数
    User loginUser(@Param("userName") String userName, @Param("passWord") String passWord);

    List<User> queryAllUser();
}
