package com.woniu.dao;

import com.woniu.pojo.Menu;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Set;

@Repository
public interface MenuDao {
    public List<Menu> getAllMenus();
    public Set<String> getUrlByUserName(String userName);
    public void save(Map<String,Integer> params);
    public void delete(Integer roleId);

}
