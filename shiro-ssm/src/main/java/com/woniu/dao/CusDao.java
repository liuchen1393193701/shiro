package com.woniu.dao;

import com.woniu.pojo.Customer;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CusDao {
    public List<Customer> findAll(@Param("name") String name);

    public boolean add(Customer customer);
}
