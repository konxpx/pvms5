package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.charts_pieMapper;
import com.example.salecar.service.ichartspieService;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class chartspieServiceimpl implements ichartspieService{
    final charts_pieMapper charts_pieMapper;

    public chartspieServiceimpl(com.example.salecar.dao.charts_pieMapper charts_pieMapper) {
        this.charts_pieMapper = charts_pieMapper;
    }
    public JSONObject showstate(){
        JSONObject resp = new JSONObject();
        try {
            PageInfo pageInfo = new PageInfo(charts_pieMapper.quanofstate());
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
    public JSONObject showbook(){
        JSONObject resp = new JSONObject();
        try {
            PageInfo pageInfo = new PageInfo(charts_pieMapper.quanofbook());
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
