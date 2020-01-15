package com.woniu.service;

import com.woniu.pojo.Menu;

import java.util.List;
import java.util.Set;

public interface MenuService {
    public List<Menu> getAllMenus();
    public Set<String> getUrlByUserName(String userName);
}
