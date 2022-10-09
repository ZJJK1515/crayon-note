package com.crayon.user.feign;

import com.crayon.common.core.Result;
import com.crayon.user.clientobject.CrayonTokenCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("CRAYON-USER-API")
public interface CrayonUserClientFeign {

    @RequestMapping(value = "/api/v1/login", method = RequestMethod.POST)
    Result<CrayonTokenCO> login(@RequestBody CrayonUserLoginCommand crayonUserLoginCommand);
}
