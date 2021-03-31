package com.valo.mybatis;

import com.valo.mybatis.domain.User;
import com.valo.mybatis.mapper.UserMapper;
import com.valo.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

/**
 * Hello world!
 */
public class Main {
    public static void main(String[] args) {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 1. 方式一 getMapper 执行sql 推荐
        List<User> user = sqlSession.getMapper(UserMapper.class).getUser();
        System.out.println(user);

        System.out.println("=======================");

        // 方式二 不推荐
        List<User> userList = sqlSession.selectList("com.valo.mybatis.mapper.UserMapper.getUser");
        System.out.println("userList=>" + userList);
        sqlSession.close();

    }
}
