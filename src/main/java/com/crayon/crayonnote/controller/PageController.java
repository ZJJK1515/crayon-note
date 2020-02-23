package com.crayon.crayonnote.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class PageController {

    @RequestMapping("/")
    public String index() {
        return home();
    }


    @RequestMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping(value = "/getPage")
    public String getPage(String uri) {
        return uri;
    }

    @RequestMapping("/getFooter")
    public String getFooter() {
        return "system/usermanage";
    }

}
