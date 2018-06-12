package com.cpumax.springfilter.control;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public  Object hello(String name){
        System.out.print("name:"+name);
        return "hello";
    }
    @RequestMapping("/login")
    public  Object login(String name){
        System.out.print("name:"+name);
        return "hello";
    }
}
