package com.crayon.user.adapter;

import com.crayon.user.clientobject.CrayonUserCO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/userManagement")
public class CrayonUserManagementAdapter {

    @RequestMapping("/getList")
    public List<CrayonUserCO> getList() {
        return null;
    }

}
