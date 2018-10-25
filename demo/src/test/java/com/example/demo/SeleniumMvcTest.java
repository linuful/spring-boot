package com.example.demo;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.safari.SafariDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class SeleniumMvcTest {
    private static SafariDriver browser;

    //open SafariDriver browser before ut
    @BeforeClass
    public static void openBrowser(){
        browser = new SafariDriver();
        browser.manage().timeouts()
                .implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterClass
    public static void closeBrowser(){
        browser.quit();
    }

    @Test
    public void test1(){

        browser.get("https://www.baidu.com");
        System.out.println(browser.getTitle());

        System.out.println("tested completed");

    }
}
