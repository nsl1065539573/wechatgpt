package com.example.wechatgpt.controller;

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
}
