package org.valo;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.valo.service.SomeService;
import org.valo.service.impl.SomeServiceImpl;

import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {
    @Test
    public void test01() {
        SomeService service = new SomeServiceImpl();
        service.doSome();
    }

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
}
