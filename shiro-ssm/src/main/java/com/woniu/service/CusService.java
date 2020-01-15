package com.woniu.service;

import com.woniu.pojo.Customer;

import java.util.List;

public interface CusService {
    public List<Customer> findAll(String name);
    public boolean add(Customer customer);
}
