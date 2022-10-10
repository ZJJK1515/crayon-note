package com.crayon.user.clientobject;

import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
public class CrayonLoginCO {

    private Long userId;
    private String username;
    private String email;
    private String avatar;
    private Set<String> permissions;
}
