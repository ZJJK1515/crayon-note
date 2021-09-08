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
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

@Service
public class CrayonLogServiceImpl extends ServiceImpl<CrayonLogMapper, CrayonLog> {

    @Autowired
    private CrayonLogMapper crayonLogMapper;

    Executor executor = Executors.newFixedThreadPool(100);


    public int testTransaction() {
        testInsert();
        return 1;
    }

    @Transactional
    public int testInsert() {
        CrayonLog crayonLog = new CrayonLog();
        crayonLog.setLogId(CrayonIdWorker.generateId());
        crayonLog.setLogContent("测试事务");
        crayonLogMapper.insert(crayonLog);
        throw new RuntimeException();
    }

    public List<CrayonLog> testFindALl() {
        return crayonLogMapper.selectList(null);
    }


    public CrayonLog selectOne() {
        CrayonLog condition = new CrayonLog();
        condition.setLogId(1425005002615406594L);
        QueryWrapper<CrayonLog> wrapper = new QueryWrapper<>();
        wrapper.setEntity(condition);
        return this.getOne(wrapper);

    }


}
