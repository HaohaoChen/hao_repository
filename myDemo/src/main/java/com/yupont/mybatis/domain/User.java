package com.yupont.mybatis.domain;

import java.io.Serializable;

/**
 * Created by Administrator on 2017/12/21 0021.
 */
public class User implements Serializable{
    private static final long serialVersionUID = -1L;

    private String id;
    private String userName;
    private String passWord;
    private String age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
