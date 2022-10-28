package com.crayon.user.service.impl;

import com.crayon.common.core.Result;
import com.crayon.user.clientobject.CrayonUserCO;
import com.crayon.user.command.CrayonUserGetListCommand;
import com.crayon.user.infrastructure.gateway.ICrayonUserGateway;
import com.crayon.user.service.ICrayonUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class CrayonUserServiceImpl implements ICrayonUserService {

    @Resource
    private ICrayonUserGateway crayonUserGateway;

    @Override
    public Result<CrayonUserCO> getList(CrayonUserGetListCommand crayonUserGetListCommand) {
        return null;
    }
}
