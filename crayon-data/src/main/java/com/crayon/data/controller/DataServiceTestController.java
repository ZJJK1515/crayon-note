package com.crayon.data.controller;

import com.crayon.data.service.impl.CrayonLogServiceImpl;
import com.crayon.pojo.po.CrayonLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/data")
public class DataServiceTestController {

    @Autowired
    private CrayonLogServiceImpl crayonLogService;

    @RequestMapping("/test")
    public String test() {
        return "data service ok!";
    }


    @RequestMapping("/save")
    public int save() {
        return crayonLogService.testTransaction();
    }

    @RequestMapping("/testFindALl")
    public List<CrayonLog> testFindALl() {
        return crayonLogService.testFindALl();
    }

    @RequestMapping("/selectOne")
    public CrayonLog selectOne() {
        return crayonLogService.selectOne();
    }

}
