package com.example.wechatgpt.controller.request;

import lombok.Data;
import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@ToString
@XmlRootElement(name = "xml")
public class WechatMessageRequest {
  @XmlElement(name = "ToUserName")
  public String toUserName;
  @XmlElement(name = "FromUserName")
  public String fromUserName;
  @XmlElement(name = "CreateTime")
  public String createTime;
  @XmlElement(name = "MsgType")
  public String msgType;
  @XmlElement(name = "Content")
  public String content;
  @XmlElement(name = "MsgId")
  public String msgId;
}
