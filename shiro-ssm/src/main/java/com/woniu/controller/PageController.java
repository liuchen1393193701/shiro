package com.woniu.controller;
import com.woniu.pojo.Menu;
import com.woniu.service.MenuService;
import com.woniu.service.impl.MenuServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PageController {

    @Autowired
    private MenuService menuService;
    @RequestMapping("leftMenu.html")
    @ResponseBody
    public List<Menu> leftMenu(){
        return this.menuService.getAllMenus();
    }
    @RequestMapping("index.html")
    public String index(){
        return "index";
    }
    @RequestMapping("error.html")
    public String error(){
        return "error";
    }
}
