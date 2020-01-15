package com.woniu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/menu")
public class MenuController {
    @RequestMapping("goList.html")
    public String goList(){
        System.out.println("********************");
        return "/menu_list";
    }
}

