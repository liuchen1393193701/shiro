package com.woniu.service;

import com.woniu.pojo.Role;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoleService {
    //分页列表
    public List<Role> getRoleByPages(Integer currentPage, Integer lineSize);
    //查询记录总数
    public int getCount();
    //计算总页数
    public int getTotalPage(Integer count,Integer lineSize);
    public Integer[] getMenuIdsByRoleId(Integer roleId);
    public boolean assignPermission(Integer roleId,String perArray);
}
