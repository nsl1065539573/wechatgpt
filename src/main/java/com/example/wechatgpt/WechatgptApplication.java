package com.example.wechatgpt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties
public class WechatgptApplication {

  public static void main(String[] args) {
    SpringApplication.run(WechatgptApplication.class, args);
  }

}
