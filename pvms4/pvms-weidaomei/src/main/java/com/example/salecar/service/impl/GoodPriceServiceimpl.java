package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.GoodPriceMapper;
import com.example.salecar.pojo.Goodprice;
import com.example.salecar.service.IgoodPriceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class GoodPriceServiceimpl implements IgoodPriceService {
    final GoodPriceMapper goodPriceMapper;

    public GoodPriceServiceimpl(GoodPriceMapper goodPriceMapper) {
        this.goodPriceMapper = goodPriceMapper;
    }

    @Override
    public JSONObject addPrice(Goodprice goodprice) {
        JSONObject resp = new JSONObject();
        try {
            goodPriceMapper.insert(goodprice.getCar_id(), goodprice.getCp_price1(), goodprice.getCp_disc(),
                    goodprice.getCp_disctype(), goodprice.getCp_price2());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "insert error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", "200");
        resp.put("msg", "insert successful");
        return resp;
    }

    @Override
    public JSONObject deletePrice(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            goodPriceMapper.delete(id);
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "delete error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", "200");
        resp.put("msg", "delete successful");
        return resp;
    }

    @Override
    public JSONObject getPriceById(Integer id) {
        Goodprice goodprice;
        try {
            goodprice = goodPriceMapper.selectPriceById(id);
        } catch (Exception e) {
            JSONObject resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
            return resp;
        }
        JSONObject resp;
        if (goodprice == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the carprice not exist");
        } else {
            resp = (JSONObject) JSONObject.toJSON(goodprice);
            resp.put("code", 200);
            resp.put("msg", "select successful");
        }
        return resp;
    }

    @Override
    public JSONObject updatePrice(Goodprice goodprice) {
        JSONObject resp = new JSONObject();
        try {
            goodPriceMapper.update(goodprice.getCp_id(), goodprice.getCar_id(), goodprice.getCp_price1(),
                    goodprice.getCp_disc(), goodprice.getCp_disctype(), goodprice.getCp_price2());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "update error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "update successful");
        return resp;
    }

    @Override
    public JSONObject showPrice(String searchpid,String searchcid,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(goodPriceMapper.getPriceList(searchpid,searchcid));
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
