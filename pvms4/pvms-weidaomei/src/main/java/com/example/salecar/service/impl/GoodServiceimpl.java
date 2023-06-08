package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.GoodMapper;
import com.example.salecar.pojo.Good;
import com.example.salecar.service.IgoodService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class GoodServiceimpl implements IgoodService {
    final GoodMapper goodMapper;

    public GoodServiceimpl(GoodMapper goodMapper) {
        this.goodMapper = goodMapper;
    }

    public JSONObject getCarById(Integer id) {
        JSONObject resp;
        Good good;
        try {
            good = goodMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (good == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the car not exist");
            return resp;
        } else {
            resp = (JSONObject) JSONObject.toJSON(good);
            resp.put("code", 200);
            resp.put("msg", "select successful");
        }
        return resp;
    }

    @Override
    public JSONObject addCar(Good good) {
        JSONObject resp = new JSONObject();
        try {
            goodMapper.insert(good.getGoods_type(), good.getGoods_brand(), good.getSup_id(), good.getGoods_color(), good.getGoods_comment(), good.getGoods_engine(), good.getGoods_trans());
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
    public JSONObject deleteCar(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            goodMapper.deleteByPrimaryKey(id);

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
    public JSONObject updateCar(Good good) {
        JSONObject resp = new JSONObject();
        try {
            goodMapper.updateByPrimaryKey(good.getGoodss_id(), good.getGoods_type(), good.getGoods_brand(), good.getSup_id(), good.getGoods_color(), good.getGoods_comment(), good.getGoods_engine(), good.getGoods_trans());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "update car error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "update car successful");
        return resp;
    }

    @Override
    public JSONObject showCars(String searchcarid,String searchsid,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(goodMapper.showgoods(searchcarid,searchsid));
            resp.put("code", 200);
            resp.put("msg", "show cars successful");
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
