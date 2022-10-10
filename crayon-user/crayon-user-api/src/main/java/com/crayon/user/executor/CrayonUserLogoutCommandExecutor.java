package com.crayon.user.executor;

import com.crayon.common.core.Result;
import com.crayon.common.redis.RedisUtil;
import com.crayon.user.command.CrayonUserLogoutCommand;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@Component
public class CrayonUserLogoutCommandExecutor {


    @Resource
    private RedisUtil redisUtil;

    public Result<Void> execute(CrayonUserLogoutCommand crayonUserLogoutCommand) {
        return null;
    }
}
