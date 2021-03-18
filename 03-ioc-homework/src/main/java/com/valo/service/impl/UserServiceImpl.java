package com.valo.service.impl;

import com.valo.dao.UserDao;
import com.valo.domain.SysUser;
import com.valo.service.UserService;

public class UserServiceImpl implements UserService {

    // 引用类型 在xml文件给属性赋值 要求属性有set方法
    private UserDao dao;

    public void setDao(UserDao dao) {
        this.dao = dao;
    }

    @Override
    public void addUser(SysUser user) {
        // 调用dao的方法
        dao.insertUser(user);
    }
}
