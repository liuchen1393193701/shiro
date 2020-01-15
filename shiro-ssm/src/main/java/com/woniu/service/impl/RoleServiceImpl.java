package com.woniu.service.impl;

import com.woniu.dao.MenuDao;
import com.woniu.dao.RoleDao;
import com.woniu.pojo.Role;
import com.woniu.pojo.User;
import com.woniu.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Role> getRoleByPages(Integer currentPage, Integer lineSize) {
        Integer from = (currentPage-1)*lineSize;
        return this.roleDao.getRoleByPage(from,lineSize);
    }

    @Override
    public int getCount() {
        return this.roleDao.getCount();
    }

    @Override
    public int getTotalPage(Integer count, Integer lineSize) {
        return count%lineSize==0?count/lineSize:count/lineSize+1;
    }

    @Override
    public Integer[] getMenuIdsByRoleId(Integer roleId) {
        return this.roleDao.getMenuIdsByRoleId(roleId);
    }

    @Override
    public boolean assignPermission(Integer roleId, String perArray) {
        boolean flag = false;
        try {
            this.menuDao.delete(roleId);
            String[] perIdArray = perArray.split(",");
            if (perIdArray!=null&&perIdArray.length>0){
                for (String idStr : perIdArray) {
                    int menuId=Integer.parseInt(idStr);
                    Map<String,Integer> params = new HashMap<String,Integer>();
                    params.put("roleId",roleId);
                    params.put("menuId",menuId);
                    this.menuDao.save(params);
                }
            }
            flag=true;
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }
        return flag;
    }

}
