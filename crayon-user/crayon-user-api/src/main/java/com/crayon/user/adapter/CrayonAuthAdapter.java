package com.crayon.user.adapter;

import com.crayon.common.core.Result;
import com.crayon.user.clientobject.CrayonTokenCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import com.crayon.user.command.CrayonUserLogoutCommand;
import com.crayon.user.service.ICrayonAuthService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/api/v1")
public class CrayonAuthAdapter {

    @Resource
    private ICrayonAuthService crayonAuthService;

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Result<CrayonTokenCO> login(@RequestBody CrayonUserLoginCommand crayonUserLoginCommand) {
        return crayonAuthService.login(crayonUserLoginCommand);
    }

    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public Result<Void> logout(@RequestBody CrayonUserLogoutCommand crayonUserLogoutCommand) {
        return crayonAuthService.login(crayonUserLogoutCommand);
    }

}
