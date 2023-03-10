package com.example.wechatgpt.controller;

import com.example.wechatgpt.config.WechatPublicConfig;
import com.example.wechatgpt.controller.request.WechatMessageRequest;
import com.example.wechatgpt.controller.response.ChatResponse;
import com.example.wechatgpt.controller.response.WechatMessageResponse;
import com.example.wechatgpt.util.CheckUtil;
import com.example.wechatgpt.util.HttpUtil;
import com.example.wechatgpt.util.XMLUtil;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.bind.JAXBException;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * 微信公众号后台接口
 * 第一版简单全写一个里 后面改
 **/
@RestController
public class WechatPublicController {
  private static final ObjectMapper objectMapper = new ObjectMapper();
  static {
    objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
  }

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

  @PostMapping(value = "/verify_wx_token", consumes = MediaType.TEXT_XML_VALUE, produces = MediaType.APPLICATION_XML_VALUE)
  public String verifyWxTokenPost(@RequestBody WechatMessageRequest request) throws JAXBException {
    Map<String, Object> params = new HashMap<>();
    params.put("model", "text-davinci-003");
    params.put("temperature", 0.9);
    params.put("max_tokens", 1000);
    params.put("top_p", 1);
    params.put("frequency_penalty", 0);
    params.put("stop", new String[]{"end~"});
    params.put("prompt", request.content + "end~");
    System.out.println("look look 请求 " + request.content);
    Map<String, String> headerMap = new HashMap<>();
    headerMap.put("Authorization", "Bearer " + wechatPublicConfig.getApiKey());
    headerMap.put("Content-Type", "application/json");
    String res = HttpUtil.sendPost(wechatPublicConfig.getChatGptUrl(), params, headerMap);
    WechatMessageResponse response = new WechatMessageResponse();
    response.toUserName = request.fromUserName;
    response.fromUserName = request.toUserName;
    response.createTime = new Date().getTime();
    response.msgType = "text";
    ChatResponse chatResponse;
    try {
      chatResponse = objectMapper.readValue(res, ChatResponse.class);
      response.content = "<![CDATA[" + chatResponse.getChoices().get(0).getText() + "]]>";
    } catch (IOException e) {
      response.content = "<![CDATA[网络异常，请稍后重试]]>";
    }
    String xmlStr = XMLUtil.parseToXml(response);
    xmlStr = xmlStr.substring(xmlStr.indexOf('>') + 1);
    return xmlStr;
  }
}
