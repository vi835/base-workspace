package com.valo.ba02;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myStudent")
public class Student {
    /**
     * @value:简单类型的属性赋值 属性: value是string类型的 表示简单类型的属性值
     * 位置: 1.在属性定义的上面 无需set方法 推荐使用
     * 2.在set方法的上面
     */

    @Value(value = "张飞")
    private String name;
    @Value(value = "10")
    private Integer age;

    public Student() {
        System.out.println("调用了Student的无参构造方法创建了对象");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
