package com.example.wechatgpt.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 微信公众号相关配置
 **/

@Data
@Component
@ConfigurationProperties(prefix = "wechat")
public class WechatPublicConfig {
  private String token;
  private String chatGptUrl; // chatgpt的请求url
  private String apiKey;
}
