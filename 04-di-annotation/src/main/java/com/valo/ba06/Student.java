package com.valo.ba06;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component(value = "myStudent06")
public class Student {
    /**
     * @value:简单类型的属性赋值 属性: value是string类型的 表示简单类型的属性值
     * 位置: 1.在属性定义的上面 无需set方法 推荐使用
     * 2.在set方法的上面
     */

    @Value(value = "周瑜")
    private String name;
    @Value(value = "20")
    private Integer age;

    /**
     * 引用类型
     *
     * @Resource: 来自jdk中的注解 spring框架提供了对这个注解的功能支持  可以使用它给引用类型赋值
     * 使用的也是自动注入原理 支持byName byType默认是byName
     * <p>
     * 位置
     * 1.在属性定义的上面 无需set方法 推荐使用
     * 2.在set方法的上面
     *
     * @Resource只使用byName方式 需要增加一个属性 name
     * name的值是bean的id(名称)
     */
    // 默认是byName:先使用byName自动注入 如果byName失败 在使用byType
    @Resource(name = "mySchool06")
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
