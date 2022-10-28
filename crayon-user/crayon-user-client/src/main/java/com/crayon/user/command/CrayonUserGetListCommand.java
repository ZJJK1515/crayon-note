package com.crayon.user.command;

import lombok.Data;

@Data
public class CrayonUserGetListCommand {

    private Integer pageSize;

    private Integer pageNo;
    
    private String username;

}
