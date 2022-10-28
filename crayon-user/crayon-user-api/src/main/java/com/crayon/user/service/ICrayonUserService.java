package com.crayon.user.service;

import com.crayon.common.core.Result;
import com.crayon.user.clientobject.CrayonUserCO;
import com.crayon.user.command.CrayonUserGetListCommand;

public interface ICrayonUserService {

    Result<CrayonUserCO> getList(CrayonUserGetListCommand crayonUserGetListCommand);

}
