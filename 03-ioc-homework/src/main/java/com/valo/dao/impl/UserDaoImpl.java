package com.valo.dao.impl;

import com.valo.dao.UserDao;
import com.valo.domain.SysUser;

public class UserDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("user插入到mysql数据库中了");
    }
}
