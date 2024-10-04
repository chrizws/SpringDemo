package com.example.springdemo;

import org.springframework.boot.ApplicationContextFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//@SpringBootApplication
public class SpringDemoApplication {

    public static void main(String[] args) {
        //SpringApplication.run(SpringDemoApplication.class, args);

        ApplicationContext ctx = new AnnotationConfigApplicationContext(Config.class);

        Student student = ctx.getBean(Student.class);
        System.out.println(student.getClass());
        Laptop l1 = ctx.getBean("lap", Laptop.class);
        Laptop l2 = ctx.getBean("lap2", Laptop.class);

        Laptop l = ctx.getBean("lap", Laptop.class);
        System.out.println("l1 == l2 : " + (l1 == l2));
        System.out.println("l == l1 : " + (l == l1));

        System.out.println(l1.getClass());
        System.out.println(l2.getClass());

        Laptop laptop = ctx.getBean(Laptop.class);
        System.out.println(laptop.getClass());



    }

}
