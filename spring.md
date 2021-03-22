# spring基础

## 核心技术

ioc aop 实现模块之间、类之间的解耦合

### IOC

#### 描述

把对象的创建 赋值 管理工作都交给代码之外的容器实现 也就是对象的创建是由其它外部资源完成的

#####  控制

创建对象 对象的属性赋值 对象之间的关系管理

#####  反转

把原来的开发人员管理 创建对象的权限转移给代码之外的容器实现 有容器`spring`代替开发人员管理对象 创建对象 给属性赋值

#####  正转

由开发人员再代码中 使用new构造方法创建对象  开发人员主动管理对象

```java
Student student = new Student();
```

#### 为什么要使用ioc

目的就是减少对代码的改动 也能上出现不同的功能

#### java中创建对象有哪些方式

1. 构造方法 new Student()
2. 反射
3. 序列化
4. 克隆
5. ioc 容器创建对象
6. 动态代理

#### ioc的体现

##### servlet

1. 创建类继承servlet

2. 再web.xml中注册servlet使用<servlet-name> myservlet</servlet-name>

   ​                                                    <servlet-class> 全限定名 </servlet-class>

3. 没有创建servelt对象 没有 MyServlet servlet= new MyServlet();

4. Servlet是Tomcat服务器创建的 Tomcat也是一种容器

   Tomcat作为容器：里面存放的有servlet对象 Listener、Filter对象

#### ioc的技术实现

DI 是 ioc的技术实现 

##### DI

DI (Dependency Injection) : 依赖注入，只需要在程序中提供要使用的对象名称就可以 至于对象如何在容器中创建、赋值、查找都由容器                 内部实现

##### spring的ioc

spring是使用的DI实现了ioc的功能 spring底层创建对象 使用的是反射机制

spring是一个容器 管理对象 给属性赋值 底层是反射创建对象

#### spring创建bean对象

##### 示例  基于xml

```xml
<!-- 告诉spring创建对象
     声明bean 就是告诉spring要创建某个类的对象
     id：对象的自定义名称 唯一值 spring通过这个名称找到对象
     class：类的全限定名称(不能是接口 因为spring是反射机制创建对象 必须使用类)
     spring是把创建好的对象放入到map中 spring框架有一个map存放对象的
     springMap.put(id的值,对象)
     -->
    <bean id="someService" class="org.valo.service.impl.SomeServiceImpl"></bean>
```

```java
/**
     * Spring默认创建对象的时间：在创建spring容器的时候 会创建配置文件中的所有的对象
     * spring创建对象 默认调用的是无参构造方法
     */
    @Test
    public void test02() {
        // 使用spring容器创建的对象
        // 1.指定spring配置文件的名称
        String config = "beans.xml";
        // 2.创建表示spring容器的对象 ApplicationContext
        // ApplicationContext就是表示spirng容器 通过容器对象获取bean对象了
        // ClassPathXmlApplicationContext:表示从类路径中加载spring的配置文件
        // 类路径 指的是项目编译过后的classes文件假
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        // 从容器中获取某个对象 你要调用对象的方法
        // getBean(“配置文件中的bean的id值”)
        SomeService someServeice = (SomeService) applicationContext.getBean("someService");

        // 使用spring创建好的对象
        someServeice.doSome();
    }

    /**
     * 获取spring容器中java对象的信息
     */
    @Test
    public void test03() {
        String config = "beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        // 使用spring提供的方法 获取容器中定义的对象的数量
        int nums = applicationContext.getBeanDefinitionCount();
        System.out.println("容器中定义的对象数量:" + nums);
        // 容器中每个定义的对象的名称
        String[] names = applicationContext.getBeanDefinitionNames();
        for (String name : names) {
            System.out.println("容器中定义的对象名称:" + name);
        }
    }

    /**
     * 获取一个非定义的类对象
     */
    @Test
    public void test04() {
        String config = "beans.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        // 使用getBean()
        Date myDate = (Date) applicationContext.getBean("myDate");
        System.out.println("Date:"+myDate);
    }
```

##### 示例 基于注解

通过注解完成java对象的创建 属性赋值

###### 使用注解的步骤

1. 加入maven的依赖``spring-context``，在你加入``spring-context``的同时 间接加入``spring-aop``的依赖 使用注解必须使用``spring-aop``的依赖
2. 在类中加入spring的注解(多个不同的注解)
3. 在spring的配置文件中 加入一个组件扫描器的标签 说明注解在你的项目中的位置

###### 常用注解

1. @Component
2. @Repository
3. @Service
4. @Controller
5. @Value
6. @Autowired
7. @Resource



# CGLB

CGLB代理的生成原理是生成目标类的子类 而子类是增强过的 这个子类对象就是代理对象 所以 使用CGLB生成动态代理 要求目标类必须能够被继承 即不能是final的类

# 动态代理

## 使用代理模式的作用

1. 功能增强: 在你原有的功能上 增加了额外的功能。新增加的功能 叫做功能增强
2. 控制访问: 代理类不让你访问目标

## 实现代理的方式

### 静态代理: 

代理类是自己手工实现的 自己创建一个java类 表示代理类。同时 你所要代理的目标类是确定的。

优点 实现简单 容易理解

缺点  当你的项目中 目标类和代理类很多的时候 有以下的缺点

​         当目标类增加了 代理类可能也需要成倍的增加 代理类数量过多

​         当你的接口中功能增加了 或者修改了 会影响众多的实现类 代理都需要修改 影响比较多

​    模拟一个用户购买u盘的行为

​    用户是客户端类

​    商家 代理 代理某个品牌的u盘

​    厂家 目标类

​    三者的关系 用户(客户端)--商家(代理)--厂家(目标)

​    商家和厂家都是卖u盘的 他们完成的功能是一致的 都是卖u盘

实现步骤

1. 创建一个接口 定义卖u盘的方法 表示你的厂家和商家做的事情
2. 创建厂家类 实现1步骤的接口
3. 创建商家 就是代理 也需要实现步骤1的接口
4. 创建客户端类 调用商家的方法买一个u盘

代理类完成的功能:

1. 目标类中方法的调用
2. 功能增强

### 动态代理: 

在静态代理中目标类很多的时候 可以使用动态代理价 避免静态代理的缺点

动态: 在程序执行时 调用jdk提供的方法 才能创建代理类的对象

动态代理中目标类即使很多

1. 代理类数量依然可以很少
2. 当你修改了接口中的方法时 不会影响代理类 

概念：在程序执行过程中 使用jdk的反射机制 创建代理类对象 并动态的指定要代理目标类

​            换句话说 动态代理就是一种创建java对象的能力 让你不用创建具体的类 就能创建代理类对象

在java中 要想创建对象

1. 创建类文件 java文件编译为class
2. 使用构造方法 创建类的对象

#### 动态代理的实现方式

1. jdk动态代理：使用java反射包中的类和接口实现动态代理的功能 反射包java.lang.reflect 里面有三个类 InvocatioHandler、Method、Proxy
2. cglib动态代理：cglib是第三方的工具库 创建代理对象 cglib的原理是继承 cglib通过继承目标类 创建它的子类 在子类中重写父类中同名的方法 实现功能的修改

​        因为cglib是继承 重写方法 所以要求目标类不能是final的 方法也不能是final的 cglib的要求目标类比较宽松 只要能继承就可以了 cglib在很多的框架中使用 比如mybatis spring框架中都有使用

### jdk动态代理



 

