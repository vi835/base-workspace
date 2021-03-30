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

        // 执行sql
        List<User> user = sqlSession.getMapper(UserMapper.class).getUser();
        System.out.println(user);

        sqlSession.close();

    }
}
