package com.woniu.service.impl;

import com.woniu.dao.CusDao;
import com.woniu.pojo.Customer;
import com.woniu.service.CusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @PackageName: com.woniu.service.impl
 * @ClassName: CusServiceImpl
 * @Author: liuchen
 * @Date: 2020/1/15 11:25
 * @Description: //TODO
 */
@Service
public class CusServiceImpl implements CusService {
    @Autowired
    private CusDao cusDao;
    @Override
    public List<Customer> findAll(String name) {
        return this.cusDao.findAll(name);
    }

    @Override
    public boolean add(Customer customer) {
        boolean flag=false;
        try {
            this.cusDao.add(customer);
            flag=true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }
}
