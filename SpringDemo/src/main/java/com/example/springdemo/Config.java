package com.example.springdemo;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

import java.util.*;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {"com.example.springdemo"})
public class Config {

    @Bean ("lap")
    //@Lazy
    @Scope(BeanDefinition.SCOPE_PROTOTYPE) //different bean instance when called
    Laptop laptop() {
        System.out.println("calling lap");
        return new Laptop();
    }


    @Bean ("lap2")
    @Primary
    @Scope(BeanDefinition.SCOPE_SINGLETON) //same bean instance when called
    Laptop laptop2() {
        System.out.println("calling lap2");
        return new Laptop();
    }
}
