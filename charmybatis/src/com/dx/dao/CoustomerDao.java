package com.dx.dao;

import com.dx.po.Customer;

import java.util.List;
import java.util.Map;

public interface CoustomerDao {
    Customer findCustomerById(int id);
    public int addCustomer(Customer customer);
    public int updateCustomer(Customer customer);
    public int deleteCustomer(int id);
    List<Customer> findAny(Map map);
}
