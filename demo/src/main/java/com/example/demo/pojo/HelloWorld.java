package com.example.demo.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HelloWorld {

    @Autowired
    Configuration cfg;

    public void helloworld(){

        System.out.println("helloworld!");


        System.out.println(cfg.getAssociateId());

    }
}
