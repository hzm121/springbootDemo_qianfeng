package com.example.demo0;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tk.mybatis.spring.annotation.MapperScan;

@MapperScan(basePackages = "com.example.demo0.dao")
@SpringBootApplication
public class Demo0Application {
    public static void main(String[] args) {
        SpringApplication.run(Demo0Application.class, args);
    }

}
