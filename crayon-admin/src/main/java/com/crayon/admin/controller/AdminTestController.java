package com.crayon.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminTestController {

    @Autowired
    ApplicationContext context;

    @RequestMapping("/test")
    public String test() {
        return "admin service ok!";
    }

}
