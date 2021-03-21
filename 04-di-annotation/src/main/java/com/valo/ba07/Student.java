package com.valo.ba07;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "myStudent07")
public class Student {
    /**
     * @value:简单类型的属性赋值 属性: value是string类型的 表示简单类型的属性值
     * 位置: 1.在属性定义的上面 无需set方法 推荐使用
     * 2.在set方法的上面
     */

    //@Value(value = "周瑜")
    @Value("${myname}")
    private String name;
    //@Value(value = "20")
    @Value("${myage}")
    private Integer age;


    @Resource(name = "mySchool07")
    private School school;

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
                ", school=" + school +
                '}';
    }
}
