package com.woniu.controller;

import com.woniu.bean.RoleBean;
import com.woniu.pojo.User;
import com.woniu.service.UserService;
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
@RequestMapping("/user")
public class UserController {
   @Autowired
    private UserService userService;
    @RequestMapping("goList.html")
    public String goList(@RequestParam(name = "currentPage",defaultValue = "1") Integer currentPage,
                         @RequestParam(name="lineSize",defaultValue ="5") Integer lineSize, HttpServletRequest request){
       if (currentPage<1){
           currentPage=1;
       }
       //求出记录总数
       int count = this.userService.getCount();
       //求出总页数
       int totalPages=this.userService.getTotalPage(count,lineSize);
       //分页数据
        if(currentPage>totalPages){
            currentPage=totalPages;
        }
        List<User> userList = this.userService.getUserByPages(currentPage,lineSize);
        request.setAttribute("currentPage",currentPage);
        request.setAttribute("lineSize",lineSize);
        request.setAttribute("count",count);
        request.setAttribute("totalPages",totalPages);
        request.setAttribute("userList",userList);
        return "user_list";
    }
    @RequestMapping("goUserRoles.html")
    public String goUserRoles(Integer userId,HttpServletRequest request){
        List<RoleBean> roleList= this.userService.getRoleBeanByUserId(userId);
        request.setAttribute("roleList",roleList);
        request.setAttribute("userId",userId);
        return "user_role";
    }

    @RequestMapping("assignRole.html")
    @ResponseBody
    public Map<String,String> assignRole(Integer userId,String roleArray){
        Map<String,String> data = new HashMap<>();
        boolean flag = this.userService.assignRoleByUserId(userId, roleArray);
        if (flag){
            data.put("msg","success");
        }else {
            data.put("msg","faliure");
        }
        return data;
    }
}
