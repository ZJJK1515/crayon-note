package com.crayon.user.infrastructure.gateway.impl;

import com.crayon.user.infrastructure.dataobject.CrayonUserDO;
import com.crayon.user.infrastructure.dataobject.repository.ICrayonUserRepository;
import com.crayon.user.infrastructure.gateway.ICrayonUserGateway;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.persistence.EntityManager;

@Component
public class ICrayonUserGatewayImpl implements ICrayonUserGateway {

    @Resource
    private ICrayonUserRepository crayonUserRepository;

    @Override
    public CrayonUserDO findByUsername(String username) {
        return crayonUserRepository.findByUsername(username);
    }

}
