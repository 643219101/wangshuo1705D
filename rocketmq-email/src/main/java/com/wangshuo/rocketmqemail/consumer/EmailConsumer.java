package com.wangshuo.rocketmqemail.consumer;

import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

@Component
@RocketMQMessageListener(topic = "sendPwdByEmail",consumerGroup = "emailgroup")
public class EmailConsumer  implements RocketMQListener<Email> {
    @Override
    public void onMessage(Email email) {
        System.out.println("=========="+email);
    }
}
