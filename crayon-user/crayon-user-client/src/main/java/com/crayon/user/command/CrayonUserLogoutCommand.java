package com.crayon.user.command;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CrayonUserLogoutCommand {

    /**
     * token
     */
    private String accessToken;

}
