package com.example.wechatgpt.controller.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.Getter;

import java.util.List;

@Data
public class ChatResponse {
  private String id;
  private String object;
  private Long created;
  private String model;
  private List<Choice> choices;
  private Usage usage;

  @Data
  public static class Choice {
    private String text;
    private Integer index;
    private String logprobs;
    /**
     * stop 代表全部输出完毕
     * length 代表受限于tokens长度无法全部输出
     */
    @JsonProperty("finish_reason")
    private String finishReason;
  }

  @Data
  public static class Usage {
    @JsonProperty("prompt_tokens")
    private Integer promptTokens;
    @JsonProperty("completion_tokens")
    private Integer completionTokens;
    @JsonProperty("total_tokens")
    private Integer totalTokens;
  }
}
