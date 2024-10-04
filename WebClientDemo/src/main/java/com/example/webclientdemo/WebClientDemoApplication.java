package com.example.webclientdemo;

import com.example.webclientdemo.controller.GreetingController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class WebClientDemoApplication {

    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(WebClientDemoApplication.class, args);
        GreetingController controller = ctx.getBean(GreetingController.class);

        // We need to block for the content here or the JVM might exit before the message is logged
        System.out.println(">> message = " + controller.getMessage().block());
    }

}
