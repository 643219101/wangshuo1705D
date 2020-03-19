package com.wangshuo.opencartback.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class EmailUtil {
@Autowired
private JavaMailSender  javaMailSender;
//异步请求
@Async
     public  void   sendEmail(String fromEmail,String toemail,String content){
         SimpleMailMessage message = new SimpleMailMessage();
         message.setFrom(fromEmail);
         message.setTo(toemail);
         message.setSubject("wangshuo管理端管理员密码重置");
         message.setText(content);
         javaMailSender.send(message);

     }

}
