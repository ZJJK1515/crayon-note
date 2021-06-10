package com.crayon.data.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.crayon.common.id.CrayonIdWorker;
import com.crayon.data.dao.CrayonLogMapper;
import com.crayon.pojo.po.CrayonLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class CrayonLogServiceImpl extends ServiceImpl<CrayonLogMapper, CrayonLog> {

    @Autowired
    private CrayonLogMapper crayonLogMapper;


    @Transactional
    public int testTransaction() {
        ArrayList<CrayonLog> crayonLogs = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            CrayonLog crayonLog = new CrayonLog();
            crayonLog.setLogId(CrayonIdWorker.generateId());
            crayonLog.setLogContent("测试事务" + i);
            crayonLogs.add(crayonLog);
        }
        boolean b = this.saveBatch(crayonLogs);
        return 1;
    }

    public List<CrayonLog> testFindALl() {
        return crayonLogMapper.selectList(null);
    }


    public CrayonLog selectOne() {
        CrayonLog condition = new CrayonLog();
        condition.setLogId(1394845198679658510L);
        QueryWrapper<CrayonLog> wrapper = new QueryWrapper<>();
        wrapper.setEntity(condition);
        return this.getOne(wrapper);

    }


}
