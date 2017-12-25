package com.yupont.redis_mybatis.dao;

import com.yupont.mybatis.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * Created by Administrator on 2017/12/25 0025.
 */
public interface LoginDao {
    //@Param("userName") 对应UserMapper.xml中传递的参数
    User loginUser(@Param("userName") String userName, @Param("passWord") String passWord);
}
