package com.crayon.user.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrayonUserLoginCommand {

    /**
     * 用户名
     */
    private String username;
    /**
     * 密码
     */
    private String password;

}
