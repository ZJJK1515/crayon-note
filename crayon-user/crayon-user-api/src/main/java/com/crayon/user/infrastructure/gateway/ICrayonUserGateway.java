package com.crayon.user.infrastructure.gateway;

import com.crayon.user.infrastructure.dataobject.CrayonUserDO;

public interface ICrayonUserGateway {

    CrayonUserDO findByUsername(String username);
}
