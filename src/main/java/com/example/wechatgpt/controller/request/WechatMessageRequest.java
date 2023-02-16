package com.example.wechatgpt.controller.request;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;
import lombok.Data;

@Data
@JacksonXmlRootElement(localName = "xml")
public class WechatMessageRequest {
  @JacksonXmlElementWrapper(localName = "ToUserName")
  private String toUserName;
  @JacksonXmlElementWrapper(localName = "FromUserName")
  private String fromUserName;
  @JacksonXmlElementWrapper(localName = "CreateTime")
  private String createTime;
  @JacksonXmlElementWrapper(localName = "MsgType")
  private String msgType;
  @JacksonXmlElementWrapper(localName = "Content")
  private String content;
  @JacksonXmlElementWrapper(localName = "MsgId")
  private String msgId;
}
