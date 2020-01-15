package com.woniu.dao;

import java.util.Set;

public interface UserDao {

    public String getPasswordByUserName(String userName);

    public Set<String> getRolesByUserName(String userName);

    public Set<String> getPermissionsByUserName(String userName);


}
