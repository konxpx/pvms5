package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Salesman;
import com.example.salecar.pojo.Staff;

public interface IsalesmanService {
    JSONObject addSalesman(Staff salesman);

    JSONObject deleteSalesman(Integer id);

    JSONObject updateSalesman(Staff salesman);

    JSONObject showSalesman(String searchName,String searchId,Integer pageNumber, Integer pageSize);

    JSONObject getSalesmanById(int id);

    JSONObject getSalesmanByAccount(String account);
}
