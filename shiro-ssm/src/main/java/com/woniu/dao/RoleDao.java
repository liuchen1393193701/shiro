package com.woniu.dao;

import com.woniu.pojo.Role;

import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface RoleDao {
    //查询系统所有的角色
    public List<Role> getAllRoles();
    //通过用户查询其拥有的角色
    public Integer[] getRoleIdByUserId(Integer userId);

    public void save(Map<String,Integer> params);

    public void delete(Integer userId);
    public List<Role> getRoleByPage(@Param("from") Integer from, @Param("lineSize") Integer lineSize);
    public int getCount();
    public Integer[] getMenuIdsByRoleId(Integer roleId);
}
