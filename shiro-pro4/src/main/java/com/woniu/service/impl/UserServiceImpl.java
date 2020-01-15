package com.woniu.service.impl;

import com.woniu.dao.UserDao;
import com.woniu.service.IUserService;
import com.woniu.utils.MyUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.Set;

public class UserServiceImpl implements IUserService {
   private UserDao userDao;

    public UserServiceImpl() {
        SqlSession sqlSession = MyUtil.getSession();
        userDao = sqlSession.getMapper(UserDao.class);
    }

    @Override
    public String getPasswordByUserName(String userName) {

        return userDao.getPasswordByUserName(userName);
    }

    @Override
    public Set<String> getRolesByUserName(String userName) {
        return userDao.getRolesByUserName(userName);
    }

    @Override
    public Set<String> getPermissionsByUserName(String userName) {
        return userDao.getPermissionsByUserName(userName);
    }
}
