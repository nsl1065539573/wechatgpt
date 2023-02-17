package com.example.wechatgpt.controller;

import com.example.wechatgpt.controller.request.WechatMessageRequest;
import com.example.wechatgpt.controller.response.WechatMessageResponse;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: nansongling
 * @Date: 2023/2/7 12:31 PM
 **/
@RestController
@RequestMapping("/test")
public class TestController {
  @GetMapping("/callback")
  public String callback(@RequestParam("a") String a) {
    return a + " callback";
  }

  @PostMapping(value = "/testXml", produces = MediaType.APPLICATION_XML_VALUE, consumes = MediaType.TEXT_XML_VALUE)
  public WechatMessageResponse testXml(@RequestBody WechatMessageRequest request) {
    System.out.println(request);
    WechatMessageResponse  response = new WechatMessageResponse();
    response.setContent("test");
    return response;
  }
}
