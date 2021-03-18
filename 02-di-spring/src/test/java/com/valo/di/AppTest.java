package com.valo.di;

import static org.junit.Assert.assertTrue;

import com.valo.di.ba01.Student;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.util.Date;

/**
 * Unit test for simple App.
 */
public class AppTest {

    @Test
    public void shouldAnswerWithTrue() {
        assertTrue(true);
    }

    @Test
    public void test01() {
        String config = "ba01/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(config);

        // 从容器中获取student对象
        Student myStudent = (Student) applicationContext.getBean("myStudent");
        System.out.println("mystudent:" + myStudent);

        Date myDate = (Date) applicationContext.getBean("myDate");
        System.out.println("myDate:" + myDate);
    }

    @Test
    public void test02() {
        String config = "ba02/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        com.valo.di.ba02.Student myStudent = (com.valo.di.ba02.Student) context.getBean("myStudent");
        System.out.println("myStudent:" + myStudent);
    }

    @Test
    public void test03() {
        String config = "ba03/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        com.valo.di.ba03.Student myStudent = (com.valo.di.ba03.Student) context.getBean("myStudent");
        System.out.println("myStudent:" + myStudent);

        com.valo.di.ba03.Student myStudent1 = (com.valo.di.ba03.Student) context.getBean("myStudent1");
        System.out.println("myStudent1:" + myStudent1);

        File myFile = (File) context.getBean("myFile");
        System.out.println("myFile的名称是" + myFile.getName());
    }

    @Test
    public void test04() {
        String config = "ba04/applicationContext.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        // 从容器中获取bean对象
        com.valo.di.ba04.Student myStudent = (com.valo.di.ba04.Student) context.getBean("myStudent");
        System.out.println("student对象=" + myStudent);
    }

    @Test
    public void test05() {
        String config = "ba05/spring-total.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(config);

        // 从容器中获取bean对象
        com.valo.di.ba05.Student myStudent = (com.valo.di.ba05.Student) context.getBean("myStudent");
        System.out.println("student对象=" + myStudent);
    }
}
