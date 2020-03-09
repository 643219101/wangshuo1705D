package com.wangshuo.opencartback.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.security.SecureRandom;

@Configuration
public class BeanConfig {
//随机出来的数字
    @Bean
    public SecureRandom secureRandom(){
        return new SecureRandom();
    }

}
