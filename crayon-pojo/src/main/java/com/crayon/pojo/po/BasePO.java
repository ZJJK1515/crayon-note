package com.crayon.pojo.po;

import lombok.Data;

import java.time.LocalDateTime;

public abstract class BasePO {

    private String createUserId;

    private String createUsername;

    private LocalDateTime createTime;

    private String updateUserId;

    private String updateUsername;

    private LocalDateTime updateTime;

    private Integer delFlag;

}
