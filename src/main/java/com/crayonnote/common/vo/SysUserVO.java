package com.crayonnote.common.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserVO {

    private String userId;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String email;
    private Boolean flag;
    private Boolean deleted;

}
