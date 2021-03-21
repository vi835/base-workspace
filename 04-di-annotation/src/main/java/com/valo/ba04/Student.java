package com.valo.ba04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component(value = "myStudent04")
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
     * @Autowired: Spring框架默认提供的注释 实现引用类型的赋值
     * Spring中通过注解给引用类型赋值 使用的是自动注入原理 支持byType byName;
     * @Autowired: 默认使用的是byType自动注入
     * <p>
     * 位置: 1.在属性定义的上面 无需set方法 推荐使用
     * 2.在set方法上面
     * <p>
     * 如果要使用byName方式 需要做的是:
     * 1.在属性上面加入@Autowired
     * 2.在属性上面加入@Qualifier(value="bean的id"):表示使用指定名称的bean 完成赋值
     */
    // byName自动注入
    @Autowired
    @Qualifier(value = "mySchool")
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
