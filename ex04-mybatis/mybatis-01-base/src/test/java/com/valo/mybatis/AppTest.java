package com.valo.mybatis;

import static org.junit.Assert.assertTrue;

import com.valo.mybatis.domain.User;
import com.valo.mybatis.mapper.UserMapper;
import com.valo.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AppTest {
    @Test
    public void test01(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行sql
        List<User> user = sqlSession.getMapper(UserMapper.class).getUser();
        System.out.println(user);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);

        System.out.println("user==>"+userById);
        sqlSession.close();
    }

    // 增删改需要提交事务
    @Test
    public void test02(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer result=mapper.insertUser(new User(5,"王五","123"));
        if(result>0){
            System.out.println("插入成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    // map测试
    @Test
    public void test03(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<Object,Object> map=new HashMap<>();
        map.put("userId","6");
        map.put("userName","小六");
        map.put("password","123455");
        Integer result=mapper.insertUser2(map);
        if(result>0){
            System.out.println("插入成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }
}
