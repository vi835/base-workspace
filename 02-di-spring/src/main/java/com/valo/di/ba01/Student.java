package com.valo.di.ba01;

import java.util.Locale;

public class Student {
    private String name;
    private int age;

    public Student() {
        System.out.println("spring会调用类的无参构造方法创建对象");
    }

    // 需要有set方法 没有set方法是报错的
    // Bean property 'name' is not writable or has an invalid setter method
    public void setName(String name) {
        System.out.println("setName:" + name);
        this.name = name.toUpperCase(Locale.ROOT);
    }

    public void setAge(int age) {
        System.out.println("setAge:" + age);
        this.age = age;
    }

    public void setEmail(String email) {
        System.out.println("setEmail:" + email);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
