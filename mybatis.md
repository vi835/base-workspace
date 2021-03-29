# MyBatis

## 介绍

- Mybatis是一款优秀的持久层框架
- 支持定制化SQL 存储过程以及高级映射
- Mybatis避免了几乎所有的JDBC代码和手动设置参数以及获取结果集
- Mybatis可以使用简单的xml或注解来配置和映射原生类型 接口和Java的POJO为数据库中的记录

### 持久层

#### 数据持久化

- 持久化就是将程序的数据在持久化和瞬时状态转化的过程
- 内存：**断电即失**
- 数据库：io文件持久化

#### 为什么需要持久化

- 有一些对鞋 不能让他丢失
- 内存太贵了



## Mybatis使用步骤

1. 定义dao接口 StudentDao

2. 定义mapper文件 StudentDao.xml

3. 定义mybatis的主配置文件 mybatis.xml

4. 创建dao的代理对象  `` StudentDao dao = SqlSession.getMapper(StudentDao.class)``

   ```java
   List<Student> students = dao.selectStudents();
   ```

## 要使用dao对象 需要使用getMapper()方法 怎么能使用getMapper()方法 需要使用哪些条件

1. 获取SqlSession对象 需要使用SqlSessionFactory.openSession()方法
2. 创建SqlSessionFactory对象 通过读取mybatis的主配置文件 就能创建SqlSessionFactory对象

## 总结

通过以上的说明 我们需要让spring创建以下对象

1. 独立的连接池类的对象 使用阿里的druid连接池
2. SqlSessionFactory对象
3. 创建出dao对象

## Tips

1. 我们会使用独立的连接池类替换mybatis默认的连接池类 把连接池类交给spring创建