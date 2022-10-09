package com.crayon.user.executor;

import com.crayon.common.core.Result;
import com.crayon.user.clientobject.CrayonTokenCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import com.crayon.user.infrastructure.dataobject.CrayonUserDO;
import com.crayon.user.infrastructure.gateway.ICrayonUserGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Slf4j
@Component
public class CrayonUserLoginCommandExecutor {

    @Resource
    private ICrayonUserGateway crayonUserGateway;

    /**
     * 登陆验证
     *
     * @param crayonUserLoginCommand 登陆
     * @return tokenCO
     */
    public Result<CrayonTokenCO> execute(CrayonUserLoginCommand crayonUserLoginCommand) {
        CrayonUserDO crayonUser = crayonUserGateway.findByUsername(crayonUserLoginCommand.getUsername());
        log.info("查询 user 结果: {}", crayonUser);
        if (crayonUser != null && crayonUser.getPassword().equals(crayonUserLoginCommand.getPassword())) {
            String token = String.join("|", crayonUser.getId().toString(), crayonUser.getUsername());

            CrayonTokenCO crayonTokenCO = new CrayonTokenCO();
            crayonTokenCO.setAccessToken(token);
            return Result.ok(crayonTokenCO);
        }
        return Result.error("用户名或密码错误");
    }

}
