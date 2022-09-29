package com.crayon.common.core;

import lombok.Data;

@Data
public class RequestInfo {
    private Long traceId;
    private String ip;
    private String requestUrl;
    private String httpMethod;
    private String classMethod;
    private Object requestParams;
    private Object result;
    private Long timeCost;
    private RuntimeException exception;
}