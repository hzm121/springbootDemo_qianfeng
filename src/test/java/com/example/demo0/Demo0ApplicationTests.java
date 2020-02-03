package com.example.demo0;

import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Before;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import java.net.MalformedURLException;
import java.net.URL;
@RunWith(SpringRunner.class)
@SpringBootTest(classes = Demo0Application.class,webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo0ApplicationTests {
    @LocalServerPort
   private int port;

    private URL base;
    @Autowired
    private TestRestTemplate template;
    @BeforeEach
    public void setUp() throws MalformedURLException {
        System.err.println("1212122"+this.base);
        this.base = new URL("http://localhost:"+port+"/");
    }
    @Test
    public void contextLoads() {
        System.err.println(template);
        ResponseEntity<String> response = template.getForEntity(base.toString(), String.class);
        Assert.assertThat(response.getBody(), CoreMatchers.equalTo("Hello SpringBoot!"));
    }

}
