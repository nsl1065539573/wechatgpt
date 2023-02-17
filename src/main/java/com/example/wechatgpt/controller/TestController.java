package com.example.wechatgpt.controller;

import com.example.wechatgpt.controller.request.WechatMessageRequest;
import com.example.wechatgpt.controller.response.WechatMessageResponse;
import com.example.wechatgpt.util.XMLUtil;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.xml.bind.JAXBException;

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
  public String testXml(@RequestBody WechatMessageRequest request) throws JAXBException {
    System.out.println(request);
    WechatMessageResponse  response = new WechatMessageResponse();
    response.setContent("test");
    String xmlStr = XMLUtil.parseToXml(response);
    xmlStr = xmlStr.substring(xmlStr.indexOf('>') + 1);
    return xmlStr;
  }
}
