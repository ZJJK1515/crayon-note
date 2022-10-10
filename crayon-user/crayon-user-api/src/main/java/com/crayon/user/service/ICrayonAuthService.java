package com.crayon.user.service;

import com.crayon.common.core.Result;
import com.crayon.user.clientobject.CrayonLoginCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import com.crayon.user.command.CrayonUserLogoutCommand;

public interface ICrayonAuthService {
    Result<CrayonLoginCO> login(CrayonUserLoginCommand crayonUserLoginCommand);

    Result<Void> login(CrayonUserLogoutCommand crayonUserLogoutCommand);
}
