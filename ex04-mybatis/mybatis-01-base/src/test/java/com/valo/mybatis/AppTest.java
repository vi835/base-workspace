package com.valo.mybatis;

import static org.junit.Assert.assertTrue;

import com.valo.mybatis.domain.User;
import com.valo.mybatis.mapper.UserMapper;
import com.valo.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.List;


public class AppTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行sql
        List<User> user = sqlSession.getMapper(UserMapper.class).getUser();
        System.out.println(user);

        sqlSession.close();
    }
}
