package com.example.wechatgpt.controller;

import com.example.wechatgpt.config.WechatPublicConfig;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;

/**
 * 微信公众号后台接口
 * 第一版简单全写一个里 后面改
 **/
@RestController
public class WechatPublicController {
  @Resource
  private WechatPublicConfig wechatPublicConfig;

  @GetMapping("/verify_wx_token")
  public String verifyWxToken(@RequestParam("signature") String signature,
                              @RequestParam("timestamp") String timestamp,
                              @RequestParam("nonce") String nonce,
                              @RequestParam("echostr") String echostr) {
    if (checkSignature(signature, timestamp, nonce, wechatPublicConfig.getToken())) {
      return echostr;
    }
    return "";
  }

  @PostMapping("/verify_wx_token")
  public String verifyWxTokenPost() {
    System.out.println("post");
    return "post";
  }

  public static boolean checkSignature(String signature, String timestamp, String nonce, String token) {
    String[] str = new String[]{token, timestamp, nonce};
    //排序
    Arrays.sort(str);
    //拼接字符串
    StringBuilder builder = new StringBuilder();
    for (String s : str) {
      builder.append(s);
    }
    //进行sha1加密
    byte[] bytes = DigestUtils.sha1(builder.toString());
    String temp = new String(bytes);
    //与微信提供的signature进行匹对
    return signature.equals(temp);
  }
}
