package com.example.wechatgpt.controller.response;

import lombok.Data;
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
  private String ToUserName;
  @XmlElement(name = "FromUserName")
  private String FromUserName;
  @XmlElement(name = "CreateTime")
  private Long CreateTime;
  @XmlElement(name = "MsgType")
  private String MsgType;
  @XmlElement(name = "MsgId")
  private Long MsgId;
  @XmlElement(name = "Content")
  private String Content;

  public String getToUserName() {
    return ToUserName;
  }

  public void setToUserName(String toUserName) {
    ToUserName = toUserName;
  }

  public String getFromUserName() {
    return FromUserName;
  }

  public void setFromUserName(String fromUserName) {
    FromUserName = fromUserName;
  }

  public Long getCreateTime() {
    return CreateTime;
  }

  public void setCreateTime(Long createTime) {
    CreateTime = createTime;
  }

  public String getMsgType() {
    return MsgType;
  }

  public void setMsgType(String msgType) {
    MsgType = msgType;
  }

  public Long getMsgId() {
    return MsgId;
  }

  public void setMsgId(Long msgId) {
    MsgId = msgId;
  }

  public String getContent() {
    return Content;
  }

  public void setContent(String content) {
    Content = content;
  }
}
