package com.example.demo;

import demo.example.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController

@ComponentScan("com.example")
public class DemoApplication {

    @Autowired(required = false)
    DemoService demoService;

    @RequestMapping("/helloworld")
    String helloWorld(){
        System.out.println("helloWorld");

        demoService.run();

        return "welcome " + demoService.getAssociateId() + ", this is Hello World!";
    }

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
}
