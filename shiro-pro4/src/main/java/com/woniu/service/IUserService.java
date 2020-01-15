package com.woniu.service;

import java.util.Set;

public interface IUserService {
    public String getPasswordByUserName(String userName);
    public Set<String> getRolesByUserName(String userName);
    public Set<String> getPermissionsByUserName(String userName);
}
