package com.woniu.service;

import com.woniu.bean.RoleBean;
import com.woniu.pojo.User;

import java.util.List;

public interface UserService {
    public User getUserByUserName(String userName);
    public User getLogin(String name, String password);
    //分页列表
    public List<User> getUserByPages(Integer currentPage,Integer lineSize);
    //查询记录总数
    public int getCount();
    //计算总页数
    public int getTotalPage(Integer count,Integer lineSize);
    //展现指定用户所拥有的角色集合
    public List<RoleBean> getRoleBeanByUserId(Integer userId);

    public boolean assignRoleByUserId(Integer userId,String roleArray);
}
