package com.valo.ba01;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

/**
 * @Component: 创建对象的注解 等同于<bean>的功能
 * 属性: value就是对象的名称 也就是bean的id值
 * value的值是唯一的,创建的对象在整个spring容器中就一个
 * <p>
 * 位置: 在类的上面
 * @Component(value = "myStudent") 等同于
 * <bean id="myStudent" class="com.valo.ba01.Student"/>
 *
 * Spring中和@Component功能一致 创建对象的注解还有
 * 1.@Repository(用在持久层类的上面):放在dao类的上面 表示创建dao对象 dao对象是能访问数据库的
 * 2.@Service(用在业务层类的上面):放在service的实现类上面 创建service上面 service对象是做业务处理的
 *                             可以有事物等功能的
 * 3.@Controller(用在控制器的上面):放在控制器(处理器)类的上面 创建控制器对象的
 *     控制器对象: 能够接收用户提交的参数 显示请求的处理结果
 * 以上三个注解的使用语法和@Component一样的 都能创建对象 但是这三个注解还有额外的功能
 * @Repository @Service @Controller是给项目的对象分层的
 */
// 如果不指定value属性名称 由spring指定默认名称 类名的首字母小写
//@Component(value = "myStudent")
@Component
public class Student {
    private String name;
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
