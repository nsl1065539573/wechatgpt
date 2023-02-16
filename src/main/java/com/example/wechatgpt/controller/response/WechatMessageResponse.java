package com.example.wechatgpt.controller.response;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

/**
 * 目前只处理文本形式
 * 先不抽父类
 */
@Data
@JacksonXmlRootElement(localName = "xml")
public class WechatMessageResponse {
  private String ToUserName;
  private String FromUserName;
  private long CreateTime;
  private String MsgType;
  private long MsgId;
  private String Content;
}
