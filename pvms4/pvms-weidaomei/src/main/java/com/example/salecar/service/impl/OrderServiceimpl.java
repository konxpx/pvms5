package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.OrderMapper;
import com.example.salecar.pojo.Order;
import com.example.salecar.service.IorderService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceimpl implements IorderService {
    final OrderMapper orderMapper;

    public OrderServiceimpl(OrderMapper orderMapper) {
        this.orderMapper = orderMapper;
    }

    @Override
    public JSONObject addOrder(Order order) {
        JSONObject resp = new JSONObject();
        try {
            orderMapper.insert(order.getCar_id(), order.getCus_id(), order.getO_status(), order.getO_ctime(),
                    order.getO_ftime(), order.getO_price());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }

        resp.put("code", 200);
        resp.put("msg", "insert successful");
        return resp;
    }

    @Override
    public JSONObject deleteOrder(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            orderMapper.deleteByPrimaryKey(id);

        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "delete successful");
        return resp;
    }

    @Override
    public JSONObject updateOrder(Order order) {
        JSONObject resp = new JSONObject();
        try {
            orderMapper.updateByPrimaryKey(order.getO_id(), order.getCar_id(), order.getCus_id()
                    , order.getO_status(), order.getO_ctime(), order.getO_ftime(), order.getO_price());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "update successful");
        return resp;
    }

    @Override
    public JSONObject getOrderById(int id) {
        JSONObject resp = new JSONObject();
        Order order;
        try {
            order = orderMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (order == null) {
            JSONObject resp1 = new JSONObject();
            resp1.put("code", 500);
            resp1.put("msg", "the order not exist");
            return resp1;
        }
        resp = (JSONObject) JSONObject.toJSON(order);
        resp.put("code", 200);
        return resp;
    }

    @Override
    public JSONObject getOrderByCustomer(String cus_name) {
        JSONObject resp = new JSONObject();
        try {
            List<Order> orders = orderMapper.selectByCustomer(cus_name);
            if (orders.size() == 0) {
                resp.put("code", 500);
                resp.put("msg", "the order not exist");
                return resp;
            }
            PageInfo pageInfo = new PageInfo(orders);
            resp.put("code", 200);
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
            return resp;
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }

    }

    @Override
    public JSONObject showOrders(String searchoid,String searchcusId,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(orderMapper.showOrders(searchoid,searchcusId));
            resp.put("code", 200);
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }

    /*@Override
    public JSONObject getOrdersByDate(String date) {
        JSONObject resp = new JSONObject();
        List<Order> orders;
        try {
            orders = orderMapper.selectByDate(date);
            if (orders.size() == 0) {
                resp.put("code", 500);
                resp.put("msg", "orders not exist");
                return resp;
            }
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        PageInfo pageInfo = new PageInfo(orders);
        resp.put("data", pageInfo.getList());
        resp.put("count", pageInfo.getTotal());
        return resp;
    }*/
}
