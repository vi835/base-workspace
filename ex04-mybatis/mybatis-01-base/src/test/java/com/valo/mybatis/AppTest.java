package com.valo.mybatis;

import com.valo.mybatis.domain.User;
import com.valo.mybatis.mapper.UserMapper;
import com.valo.mybatis.utils.MybatisUtils;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.log4j.Logger;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class AppTest {

    @Test
    public void test01() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // 执行sql
        List<User> user = sqlSession.getMapper(UserMapper.class).getUser();
        System.out.println(user);

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        User userById = mapper.getUserById(1);

        System.out.println("user==>" + userById);
        sqlSession.close();
    }

    // 增删改需要提交事务
    @Test
    public void test02() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Integer result = mapper.insertUser(new User(5, "王五", "123"));
        if (result > 0) {
            System.out.println("插入成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    // map测试
    @Test
    public void test03() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        UserMapper mapper = sqlSession.getMapper(UserMapper.class);

        Map<Object, Object> map = new HashMap<>();
        map.put("userId", "6");
        map.put("userName", "小六");
        map.put("password", "123455");
        Integer result = mapper.insertUser2(map);
        if (result > 0) {
            System.out.println("插入成功");
        }
        sqlSession.commit();
        sqlSession.close();
    }

    static Logger logger = Logger.getLogger(AppTest.class);

    @Test
    public void testLog4j() {
        logger.info("info 进入了testLog4j");
        logger.debug("debug 进入了testLog4j");
        logger.error("error 进入了testLog4j");
    }

    @Test
    public void testLimit() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Map<String, Integer> map = new HashMap<>();
        map.put("startIndex", 1);
        map.put("pageSize", 2);
        List<User> userByLimit = mapper.getUserByLimit(map);
        logger.debug("userLimit======>{}" + userByLimit.toString());
        sqlSession.close();
    }

    // rowBound实现分页 不推荐
    @Test
    public void testRowBounds() {
        SqlSession sqlSession = MybatisUtils.getSqlSession();

        // RowBounds实现
        RowBounds rowBounds = new RowBounds(0, 1);

        // 通过java代码实现分页
        List<User> users = sqlSession.selectList("com.valo.mybatis.mapper.UserMapper.getUserByRowBounds", null, rowBounds);
        logger.debug("users======>{}" + users.toString());
        sqlSession.close();
    }
}
