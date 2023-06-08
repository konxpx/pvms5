package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Order;

public interface IorderService {
    JSONObject addOrder(Order order);

    JSONObject deleteOrder(Integer id);

    JSONObject updateOrder(Order order);

    JSONObject getOrderById(int id);

    JSONObject getOrderByCustomer(String cus_name);

    JSONObject showOrders(String searchoid,String searchcusId,Integer pageNumber, Integer pageSize);

//    JSONObject getOrdersByDate(String date);
}
