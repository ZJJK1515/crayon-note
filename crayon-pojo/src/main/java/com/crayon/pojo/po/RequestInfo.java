package com.crayon.pojo.po;

import lombok.Data;

@Data
public class RequestInfo {
    private String ip;
    private String url;
    private String httpMethod;
    private String classMethod;
    private String requestParams;
    private String result;
    private Long timeCost;
}