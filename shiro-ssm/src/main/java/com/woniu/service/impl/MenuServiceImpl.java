package com.woniu.service.impl;

import com.woniu.dao.MenuDao;
import com.woniu.pojo.Menu;
import com.woniu.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class MenuServiceImpl implements MenuService {
    @Autowired
    private MenuDao menuDao;
    @Override
    public List<Menu> getAllMenus() {

        return this.menuDao.getAllMenus();
    }

    @Override
    public Set<String> getUrlByUserName(String userName) {
        return this.menuDao.getUrlByUserName(userName);
    }
}
