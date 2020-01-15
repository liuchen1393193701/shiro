package com.woniu.dao;

import com.woniu.pojo.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserDao {
    public User getUserByUserName(String userName);
    public List<User> getUserByPage(@Param("from") Integer from, @Param("lineSize") Integer lineSize);
    public int getCount();


}
