package com.crayon.common.core;

import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
public abstract class AbstractCommand {

    private String operator;

    private LocalDateTime operateTime;

}
