package com.crayonnote.common.vo;

import com.crayonnote.common.AbstractVO;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

@Data
@EqualsAndHashCode(callSuper = false)
public class SysUserVO extends AbstractVO {

    private String userId;
    private String username;
    private String password;
    private String salt;
    private String name;
    private String email;
    private boolean flag;
    private boolean deleted;

}
