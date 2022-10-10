package com.crayon.user.executor;

import com.crayon.common.core.Result;
import com.crayon.common.redis.RedisUtil;
import com.crayon.user.clientobject.CrayonLoginCO;
import com.crayon.user.command.CrayonUserLoginCommand;
import com.crayon.user.infrastructure.dataobject.CrayonUserDO;
import com.crayon.user.infrastructure.gateway.ICrayonUserGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;


@Slf4j
@Component
public class CrayonUserLoginCommandExecutor {

    @Resource
    private ICrayonUserGateway crayonUserGateway;

    @Resource
    private RedisUtil redisUtil;

    /**
     * 登陆验证
     *
     * @param crayonUserLoginCommand 登陆
     * @return tokenCO
     */
    public Result<CrayonLoginCO> execute(CrayonUserLoginCommand crayonUserLoginCommand) {
        CrayonUserDO crayonUserDO = crayonUserGateway.findByUsername(crayonUserLoginCommand.getUsername());
        log.info("查询 user 结果: {}", crayonUserDO);
        if (crayonUserDO != null && crayonUserDO.getPassword().equals(crayonUserLoginCommand.getPassword())) {
            CrayonLoginCO crayonLoginCO = new CrayonLoginCO();
            BeanUtils.copyProperties(crayonUserDO, crayonLoginCO);
            return Result.ok(crayonLoginCO);
        }
        return Result.error("用户名或密码错误");
    }


}
