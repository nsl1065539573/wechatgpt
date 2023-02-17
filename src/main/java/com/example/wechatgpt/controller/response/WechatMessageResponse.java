package com.example.wechatgpt.controller.response;

import lombok.Data;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * 目前只处理文本形式
 * 先不抽父类
 */
@Data
@XmlRootElement(name = "xml")
public class WechatMessageResponse {
  private String ToUserName;
  private String FromUserName;
  private Long CreateTime;
  private String MsgType;
  private Long MsgId;
  private String Content;
}
