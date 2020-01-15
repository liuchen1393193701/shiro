package com.woniu.controller;

import com.woniu.pojo.Customer;
import com.woniu.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @PackageName: com.woniu.controller
 * @ClassName: CusController
 * @Author: liuchen
 * @Date: 2020/1/15 11:26
 * @Description: //TODO
 */
@Controller
@RequestMapping("/cus")
public class CusController {
    @Autowired
    private CusService cusService;
    @RequestMapping("goList.html")
    public String goList(){
        return "cus_list";
    }
    @RequestMapping("findAll.html")
    @ResponseBody
    public List<Customer> findAll(String name){
        List<Customer> all=this.cusService.findAll(name);
        return all;
    }
    @RequestMapping("goAdd.html")
    public String goAdd(){
        return "cus_add";
    }
    @RequestMapping("addCus.html")
    @ResponseBody
    public Map<String,Object> addCus(@RequestBody  Customer customer){
        Map<String,Object> data=new HashMap<>();
        boolean flag=this.cusService.add(customer);
        if (flag){
            data.put("msg","success");
        }else {
            data.put("msg","failure");
        }
        return data;
    }
}
