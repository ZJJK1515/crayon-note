//package com.crayon.data.controller;
//
//import com.crayon.data.service.impl.CrayonLogServiceImpl;
//import com.crayon.pojo.po.CrayonLog;
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@Slf4j
//@RestController
//@RequestMapping("/data")
//public class DataServiceTestController {
//
//    @Autowired
//    private CrayonLogServiceImpl crayonLogService;
//
//    @RequestMapping("/test")
//    public String test() {
//        for (int i = 0; i < 100; i++) {
//            log.info("test log : {}", i);
//        }
//        return "data service ok!";
//    }
//
//
//    @RequestMapping("/save")
//    public int save() {
//        return crayonLogService.testTransaction();
//    }
//
//    @RequestMapping("/testFindALl")
//    public List<CrayonLog> testFindALl() {
//        return crayonLogService.testFindALl();
//    }
//
//    @RequestMapping("/selectOne")
//    public CrayonLog selectOne() {
//        return crayonLogService.selectOne();
//    }
//
//}
