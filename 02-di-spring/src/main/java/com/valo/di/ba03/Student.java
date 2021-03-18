package com.valo.di.ba03;

import java.util.Locale;

public class Student {
    private String name;
    private int age;

    // 声明一个引用类型
    private School school;

    public Student() {
        System.out.println("spring会调用类的无参构造方法创建对象");
    }

    /**
     * 创建有参构造方法
     * @param name
     * @param age
     * @param school
     */
    public Student(String name, int age, School school) {
        System.out.println("student调用了有参构造方法----");
        // 属性赋值
        this.name = name;
        this.age = age;
        this.school = school;
    }

    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name.toUpperCase(Locale.ROOT);
    }

    public void setAge(int age) {
        System.out.println("setAge:" + age);
        this.age = age;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
