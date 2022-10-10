package com.crayon.user.service.impl;

import com.crayon.common.core.Result;
import com.crayon.user.clientobject.CrayonLoginCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import com.crayon.user.command.CrayonUserLogoutCommand;
import com.crayon.user.executor.CrayonUserLoginCommandExecutor;
import com.crayon.user.executor.CrayonUserLogoutCommandExecutor;
import com.crayon.user.service.ICrayonAuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CrayonAuthServiceImpl implements ICrayonAuthService {

    @Resource
    private CrayonUserLoginCommandExecutor crayonUserLoginCommandExecutor;

    @Resource
    private CrayonUserLogoutCommandExecutor crayonUserLogoutCommandExecutor;

    public Result<CrayonLoginCO> login(CrayonUserLoginCommand crayonUserLoginCommand) {
        return crayonUserLoginCommandExecutor.execute(crayonUserLoginCommand);
    }

    @Override
    public Result<Void> login(CrayonUserLogoutCommand crayonUserLogoutCommand) {
        return crayonUserLogoutCommandExecutor.execute(crayonUserLogoutCommand);
    }


}
