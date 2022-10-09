package com.crayon.user.executor;

import com.crayon.common.core.Result;
import com.crayon.user.command.CrayonUserLogoutCommand;
import org.springframework.stereotype.Component;

@Component
public class CrayonUserLogoutCommandExecutor {


    public Result<Void> execute(CrayonUserLogoutCommand crayonUserLogoutCommand) {
        return null;
    }
}
