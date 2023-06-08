package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Customer;

public interface IcustomerService {
    JSONObject addCustomer(Customer customer);

    JSONObject deleteCustomer(Integer idList);

    JSONObject updateCustomer(Customer customer);

    JSONObject showCustomers(String searchName,String searchId,Integer pageNumber, Integer pageSize);

    JSONObject getCustomerById(int id);

    JSONObject getCustomerByAccount(String account);
    JSONObject getCustomerByPhone(String phone);
}
