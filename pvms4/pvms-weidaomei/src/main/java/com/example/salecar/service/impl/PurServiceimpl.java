package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.PurMapper;
import com.example.salecar.pojo.Purorder;
import com.example.salecar.service.IpurService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class PurServiceimpl implements IpurService {
    final PurMapper mapper;

    public PurServiceimpl(PurMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public JSONObject addPurorder(Purorder purorder) {
        JSONObject resp = new JSONObject();
        try {
            mapper.insert(purorder.getCar_id(), purorder.getPur_price1(), purorder.getPur_disc(), purorder.getPur_price2(), purorder.getPur_ctime(), purorder.getPur_ftime(), purorder.getPur_state());
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
    public JSONObject deletePurorder(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            mapper.delete(id);
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
    public JSONObject getPurorderById(Integer id) {
        Purorder purorder;
        try {
            purorder = mapper.selectPurorderById(id);
        } catch (Exception e) {
            JSONObject resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
            return resp;
        }
        JSONObject resp;
        if (purorder == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the chance not exist");
        } else {
            resp = (JSONObject) JSONObject.toJSON(purorder);
            resp.put("code", 200);
            resp.put("msg", "select successful");
        }
        return resp;
    }

    @Override
    public JSONObject updatePurorder(Purorder purorder) {
        JSONObject resp = new JSONObject();
        try {
            mapper.update(purorder.getPur_id(), purorder.getCar_id(), purorder.getPur_price1(), purorder.getPur_disc(),
                    purorder.getPur_price2(), purorder.getPur_ctime(), purorder.getPur_ftime(), purorder.getPur_state());
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
    public JSONObject showPurorders(String searchPid,String searchCid,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(mapper.showChances(searchPid,searchCid));
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
