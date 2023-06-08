package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Customer;
import com.example.salecar.pojo.Repository;
import com.example.salecar.pojo.Salesman;
import com.example.salecar.pojo.Staff;

public interface IloginService {
    JSONObject cusLogin(String username, String password);

    JSONObject cusRegister(Customer cust);

    JSONObject salesmanLogin(String username, String password);

    JSONObject salesmanRegister(Salesman salesman);

    JSONObject repoLogin(String username, String password);

    JSONObject repoRegister(Repository repository);

    JSONObject salesmanChangePwd(String account, String newPwd, String oldPwd);

    JSONObject repoChangePwd(String account, String newPwd, String oldPwd);

    JSONObject managerLogin(String account, String password);

    JSONObject managerRegister(Staff staff);

    JSONObject managerChangePwd(String account, String newPwd, String oldPwd);

    JSONObject cusChangePwd(String account, String newPwd, String oldPwd);
}
