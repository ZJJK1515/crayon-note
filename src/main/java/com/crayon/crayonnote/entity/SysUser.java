package com.crayon.crayonnote.entity;


import lombok.Data;

@Data
public class SysUser {

  private String userId;
  private String username;
  private String password;
  private String salt;
  private String name;
  private String email;

}
