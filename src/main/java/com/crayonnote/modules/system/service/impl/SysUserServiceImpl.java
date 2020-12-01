package com.crayonnote.modules.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crayonnote.common.entity.SysUser;
import com.crayonnote.common.utils.CrayonPageVO;
import com.crayonnote.modules.system.dao.SysUserDao;
import com.crayonnote.modules.system.service.SysUserService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserDao, SysUser> implements SysUserService {


    @Override
    public void addUser(SysUser sysUser) {

    }

    /**
     * 查询用户列表
     *
     *
     * @return
     */
    @Override
    public IPage<SysUser> findUser(CrayonPageVO<SysUser> pageVO) {
        SysUser queryVO = pageVO.getQueryVO();

        QueryWrapper<SysUser> userWrapper = new QueryWrapper<>();
        if (!StringUtils.isEmpty(queryVO.getUsername())) {
            userWrapper.like("username", pageVO.getQueryVO().getUsername());
        }

        return this.baseMapper.selectPage(pageVO, userWrapper);
    }


}
