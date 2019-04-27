package com.xzl.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class RestController {
    /**
     * 指定一个请求路径，通过该路径，进行请求到对应得方法上
     * @return
     */
    @RequestMapping("/{page}")
    public String toPage(@PathVariable("page") String page) {
        return page ;
    }
}
