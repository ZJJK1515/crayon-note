package com.crayon.user.service;

import com.crayon.common.core.Result;
import com.crayon.user.clientobject.CrayonTokenCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import com.crayon.user.command.CrayonUserLogoutCommand;

public interface ICrayonAuthService {
    Result<CrayonTokenCO> login(CrayonUserLoginCommand crayonUserLoginCommand);

    Result<Void> login(CrayonUserLogoutCommand crayonUserLogoutCommand);
}
