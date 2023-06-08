package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.CustomerMapper;
import com.example.salecar.pojo.Customer;
import com.example.salecar.service.IcustomerService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class CustomerServiceimpl implements IcustomerService {
    final CustomerMapper custMapper;

    public CustomerServiceimpl(CustomerMapper custMapper) {
        this.custMapper = custMapper;
    }

    @Override
    public JSONObject addCustomer(Customer customer) {
        JSONObject resp = new JSONObject();
        try {
            Customer customerTemp = custMapper.selectByAccount(customer.getCus_account());
            if (customerTemp != null) {
                resp.put("code", 500);
                resp.put("msg", "the customer is already exist");
                return resp;
            }
            custMapper.insert(customer.getCus_name(), customer.getCus_account(), customer.getCus_password(), customer.getCus_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "addCustomer error!");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "addCustomer successful");
        return resp;
    }

    @Override
    public JSONObject deleteCustomer(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            custMapper.deleteByPrimaryKey(id);

        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "delete customer error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "delete customer successful");
        return resp;
    }

    @Override
    public JSONObject updateCustomer(Customer customer) {
        JSONObject resp = new JSONObject();
        try {
            custMapper.updateByPrimaryKey(customer.getCus_id(), customer.getCus_name(), customer.getCus_account()
                    , customer.getCus_password(), customer.getCus_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "update customer error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "update customer successful");
        return resp;
    }

    @Override
    public JSONObject showCustomers(String searchName, String searchId, Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(custMapper.getCustomerList(searchName, searchId));
            resp.put("code", 200);
            resp.put("msg", "show customers successful");
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }

    @Override
    public JSONObject getCustomerById(int id) {
        try {
            Customer customer = custMapper.selectByPrimaryKey(id);
            if (customer == null) {
                JSONObject resp1 = new JSONObject();
                resp1.put("code", 500);
                resp1.put("msg", "the customer not exist");
                return resp1;
            }
            JSONObject resp = (JSONObject) JSONObject.toJSON(customer);
            resp.put("code", 200);
            resp.put("msg", "get successful");
            return resp;
        } catch (Exception e) {
            JSONObject resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
    }

    @Override
    public JSONObject getCustomerByAccount(String account) {
        JSONObject resp;
        Customer customer;
        try {
            customer = custMapper.selectByAccount(account);
        } catch (Exception e) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (customer == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the customer not exist");
            return resp;
        }
        resp = (JSONObject) JSONObject.toJSON(customer);
        resp.put("code", 200);
        return resp;
    }

    @Override
    public JSONObject getCustomerByPhone(String phone) {
        JSONObject resp;
        Customer customer;
        try {
            customer = custMapper.selectByPhone(phone);
        } catch (Exception e) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (customer == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the customer not exist");
            return resp;
        } else {
            resp = (JSONObject) JSONObject.toJSON(customer);
            resp.put("code", 200);
            resp.put("msg", "select successful");
        }
        return resp;
    }
}
