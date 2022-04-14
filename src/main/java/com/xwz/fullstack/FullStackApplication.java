package com.xwz.fullstack;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xwz.fullstack.mapper")
public class FullStackApplication {

    public static void main(String[] args) {
        SpringApplication.run(FullStackApplication.class, args);
    }

}
