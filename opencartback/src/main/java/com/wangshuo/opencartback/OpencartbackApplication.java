package com.wangshuo.opencartback;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@SpringBootApplication
@MapperScan("com.wangshuo.opencartback.dao")
@EnableAsync
public class OpencartbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(OpencartbackApplication.class, args);
    }

}
