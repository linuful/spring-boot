package com.example.demo;

import com.example.demo.pojo.HelloWorld;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Before
    public void before(){
        System.out.println("before hello World.");
    }

    @After
    public void after(){
        System.out.println("after hello World.");
    }

    @Autowired
    HelloWorld helloWorld;
    @Test
    public void test1() {
        helloWorld.helloworld();
    }


}
