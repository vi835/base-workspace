package com.valo;

import com.valo.ba01.Student;
import com.valo.ba03.School;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Arrays;

public class MyTest {
    @Test
    public void test01() {
        String configPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        Student myStudent = (Student) context.getBean("student");
        System.out.println("myStudent:" + myStudent);
    }

    @Test
    public void test02() {
        String configPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        com.valo.ba02.Student myStudent = (com.valo.ba02.Student) context.getBean("myStudent");
        int beanDefinitionCount = context.getBeanDefinitionCount();

        // 打印出容器中所有的bean对象
        System.out.println(Arrays.asList(context.getBeanDefinitionNames()));
        System.out.println(beanDefinitionCount);
        System.out.println("myStudent:" + myStudent);

    }

    @Test
    public void test03() {
        String configPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        com.valo.ba03.Student myStudent = (com.valo.ba03.Student) context.getBean("myStudent03");

        System.out.println("myStudent:" + myStudent);

        School school = (School) context.getBean("school");
        System.out.println("school:" + school);
        school.setName("清华大学");
        school.setAddress("五道口");
        System.out.println("myStudent:" + myStudent);
    }

    @Test
    public void test04() {
        String configPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        com.valo.ba04.Student myStudent = (com.valo.ba04.Student) context.getBean("myStudent04");

        System.out.println("myStudent:" + myStudent);

    }

    @Test
    public void test05() {
        String configPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        com.valo.ba05.Student myStudent = (com.valo.ba05.Student) context.getBean("myStudent05");

        System.out.println("myStudent:" + myStudent);
    }

    @Test
    public void test06() {
        String configPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        com.valo.ba06.Student myStudent = (com.valo.ba06.Student) context.getBean("myStudent06");

        System.out.println("myStudent:" + myStudent);
    }

    @Test
    public void test07() {
        String configPath = "/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configPath);
        com.valo.ba07.Student myStudent = (com.valo.ba07.Student) context.getBean("myStudent07");

        System.out.println("myStudent:" + myStudent);
    }
}
