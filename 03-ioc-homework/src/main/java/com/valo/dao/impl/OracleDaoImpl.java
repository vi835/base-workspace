package com.valo.dao.impl;

import com.valo.dao.UserDao;
import com.valo.domain.SysUser;

public class OracleDaoImpl implements UserDao {
    @Override
    public void insertUser(SysUser user) {
        System.out.println("oracle的insertUser方法");
    }
}
