package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.chartsMapper;
import com.example.salecar.service.ichartService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class chartsServiceimpl implements ichartService{
    final chartsMapper chartsMapper;


    public chartsServiceimpl(com.example.salecar.dao.chartsMapper chartsMapper) {
        this.chartsMapper = chartsMapper;
    }
    public JSONObject showquantity(){
        JSONObject resp = new JSONObject();
        try {
            PageInfo pageInfo = new PageInfo(chartsMapper.quanofbrand());
            resp.put("code", 200);
            resp.put("msg", "show successful");
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }

    public JSONObject showstaff(){
        JSONObject resp = new JSONObject();
        try {
            PageInfo pageInfo = new PageInfo(chartsMapper.quanofstaff());
            resp.put("code", 200);
            resp.put("msg", "show successful");
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }
    public JSONObject showordercar(){
        JSONObject resp = new JSONObject();
        try {
            PageInfo pageInfo = new PageInfo(chartsMapper.quanofordercar());
            resp.put("code", 200);
            resp.put("msg", "show successful");
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }
    public JSONObject showmoney(){
        JSONObject resp = new JSONObject();
        try {
            PageInfo pageInfo = new PageInfo(chartsMapper.quanofmoney());
            resp.put("code", 200);
            resp.put("msg", "show successful");
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }

}

