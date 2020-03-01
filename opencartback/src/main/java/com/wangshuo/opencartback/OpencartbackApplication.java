package com.wangshuo.opencartback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.wangshuo.opencartback.dao")
public class OpencartbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpencartbackApplication.class, args);
    }

}
