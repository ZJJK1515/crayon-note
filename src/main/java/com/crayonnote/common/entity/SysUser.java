package com.crayonnote.common.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SysUser {

  @TableId(type = IdType.ID_WORKER_STR)
  private String userId;
  private String username;
  private String password;
  private String salt;
  private String name;
  private String email;
  private Boolean flag;
  private Boolean deleted;

  private LocalDateTime createTime;
  private LocalDateTime updateTime;

}
