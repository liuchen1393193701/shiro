package com.woniu.controller;

import com.woniu.pojo.Menu;
import com.woniu.pojo.Role;
import com.woniu.service.MenuService;
import com.woniu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private MenuService menuService;
    @Autowired
    private RoleService roleService;

    @RequestMapping("goList.html")
    public String goList(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                         @RequestParam(name="lineSize",defaultValue ="5") Integer lineSize, HttpServletRequest request){
        if (currentPage<1){
            currentPage=1;
        }
        //求出记录总数
        int count = this.roleService.getCount();
        //求出总页数
        int totalPages=this.roleService.getTotalPage(count,lineSize);
        //分页数据
        if(currentPage>totalPages){
            currentPage=totalPages;
        }
        List<Role> roleList = this.roleService.getRoleByPages(currentPage,lineSize);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("lineSize",lineSize);
        request.setAttribute("count",count);
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("roleList",roleList);
        return "role_list";
    }
    @RequestMapping("goAssign.html")

    public String goAssign(Integer roleId,HttpServletRequest request){
        request.setAttribute("roleId",roleId);
        return "role_assign";
    }

    @RequestMapping("checkMenu.html")
    @ResponseBody
    public List<Menu> leftMenu(){
        return this.menuService.getAllMenus();
    }
    @RequestMapping("getCheck.html")
    @ResponseBody
    public Integer[] getCheck(Integer roleId){
        return this.roleService.getMenuIdsByRoleId(roleId);
    }
    @RequestMapping("assignPerm.html")
    @ResponseBody
    public Map<String,String> assignPerm(Integer roleId,String perArray){
        Map<String,String> data = new HashMap<String,String>();
        boolean flag = this.roleService.assignPermission(roleId,perArray);
        if (flag){
            data.put("msg","success");
        }else {
            data.put("msg","faliure");
        }
        return data;
    }
}
