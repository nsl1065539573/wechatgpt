package com.example.wechatgpt.controller.response;

import lombok.ToString;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 目前只处理文本形式
 * 先不抽父类
 */
@ToString
@XmlRootElement(name = "xml")
public class WechatMessageResponse {
  @XmlElement(name = "ToUserName")
  public String toUserName;
  @XmlElement(name = "FromUserName")
  public String fromUserName;
  @XmlElement(name = "CreateTime")
  public Long createTime;
  @XmlElement(name = "MsgType")
  public String msgType;
  @XmlElement(name = "MsgId")
  public Long msgId;
  @XmlElement(name = "Content")
  public String content;
}
