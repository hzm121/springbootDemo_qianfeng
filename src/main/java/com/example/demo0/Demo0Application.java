package com.example.demo0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Demo0Application {
    @RequestMapping(value = "",method = RequestMethod.GET)
public String sayHello(){
    return "Hello SpringBoot!";
}
    public static void main(String[] args) {
        SpringApplication.run(Demo0Application.class, args);
    }

}
