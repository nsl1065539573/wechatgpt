package com.example.wechatgpt.controller;

import com.example.wechatgpt.config.WechatPublicConfig;
import com.example.wechatgpt.util.CheckUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

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
    if (CheckUtil.checkSignature(signature, timestamp, nonce, wechatPublicConfig.getToken())) {
      return echostr;
    }
    return "";
  }

  @PostMapping("/verify_wx_token")
  public String verifyWxTokenPost() {
    System.out.println("post");
    return "post";
  }
}
