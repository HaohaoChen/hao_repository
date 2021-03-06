package com.yupont.redis_mybatis.service.impl;

import com.yupont.mybatis.domain.User;
import com.yupont.redis_mybatis.dao.LoginDao;
import com.yupont.redis_mybatis.service.LoginService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/12/25 0025.
 */
@Service
public class LoginServiceImpl implements LoginService {

    private static final Logger LOGGER = LoggerFactory.getLogger(LoginServiceImpl.class);

    @Autowired
    private LoginDao userDao;

    @Autowired
    private RedisTemplate redisTemplate;

    /**
     * 获取城市逻辑：
     * 如果缓存存在，从缓存中获取城市信息
     * 如果缓存不存在，从 DB 中获取城市信息，然后插入缓存
     */
    @Override
    public User loginUser(String userName, String passWord) {
        // 从缓存中获取城市信息
        String key = "user_"+userName;
        ValueOperations<String,User> operations = redisTemplate.opsForValue();
        // 缓存存在
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            User user = operations.get(key);
            LOGGER.info("LoginServiceImpl.loginUser() : 从缓存中获取了用户 -- " + user.getUserName());
            return user;
        }
        // 从DB获取数据
        User user = userDao.loginUser(userName, passWord);
        LOGGER.info("LoginServiceImpl.loginUser() : 从DB中获取了用户 == " + user.getUserName());

        // 插入缓存               100秒后从缓存失效
        operations.set(key, user, 100, TimeUnit.SECONDS);
        LOGGER.info("把用户放入缓存，用户：" + user.getUserName());

        return user;
    }

    /**
     * 更新用户逻辑：
     * 先更新DB
     * 如果缓存存在，删除
     * 如果缓存不存在，不操作
     */
    @Override
    public Integer updateUser(User user) {
        int flag = userDao.updateUser(user);
        LOGGER.info("把用户更新DB，用户：" + user.getUserName());
        // 缓存存在，删除缓存
        String key = "user_" + user.getUserName();
        boolean hasKey = redisTemplate.hasKey(key);
        if(hasKey){
            redisTemplate.delete(key);
            LOGGER.info("把用户从缓存删除，用户：" + user.getUserName());
        }
        return flag;
    }

    @Override
    public Integer deleteUser(String name) {
        int flag = userDao.deleteUser(name);
        // 缓存存在，删除缓存
        String key = "user_" +name;
        boolean hasKey = redisTemplate.hasKey(key);
        // 缓存存在，删除缓存
        if(hasKey){
            redisTemplate.delete(key);
            LOGGER.info("把用户从缓存删除，用户：" + name);
        }
        return flag;
    }
}
