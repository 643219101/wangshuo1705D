package com.wangshuo.opencartstore;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangshuo.opencartstore.dao")
public class OpencartstoreApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpencartstoreApplication.class, args);
    }

}
