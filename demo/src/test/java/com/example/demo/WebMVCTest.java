package com.example.demo;


import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.context.WebApplicationContext;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration
public class WebMVCTest {

    @Autowired
    WebApplicationContext webContext;
    private MockMvc mockMvc;

    @Before
    public void before(){
        mockMvc = MockMvcBuilders
                .webAppContextSetup(webContext)
                .build();
    }

    //local
    @Test
    public void test1() throws Exception {
        MockHttpServletRequestBuilder requestBuilder = get("/helloworld");

        MvcResult mvcResult = mockMvc.perform(requestBuilder).andExpect(status().isOk())
                .andExpect(result -> System.out.println("response is： " + result.getResponse().getContentAsString()))
                .andReturn();

        MockHttpServletRequest request = mvcResult.getRequest();
        MockHttpServletResponse response = mvcResult.getResponse();

        System.out.println("test completed!");
        //resultActions.andExpect(request().attribute("Cache-Control","max-age=0"));
    }

    //remote
    @Test
    public void test2() throws Exception {
        try {
            RestTemplate rest = new RestTemplate();
            String context = rest.getForObject(
                    "http://www.baidu.com", String.class);

            System.out.println("context: " + context);
        } catch (HttpClientErrorException e) { assertEquals(HttpStatus.NOT_FOUND, e.getStatusCode()); throw e;
        }
    }
}
