package com.crayon.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

@FeignClient(name = "CRAYON-ADMIN-SERVICE")
public interface AdminServiceFeign {

    @RequestMapping("/admin/test")
    String test();

}
