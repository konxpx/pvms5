package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.ChanceMapper;
import com.example.salecar.pojo.Chance;
import com.example.salecar.service.IchanceService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class ChanceServiceimpl implements IchanceService {
    final ChanceMapper chanceMapper;

    public ChanceServiceimpl(ChanceMapper chanceMapper) {
        this.chanceMapper = chanceMapper;
    }

    @Override
    public JSONObject addChance(Chance chance) {
        JSONObject resp = new JSONObject();
        try {
            chanceMapper.insert(chance.getCus_id(), chance.getCh_num(), chance.getCh_comment());
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
    public JSONObject deleteChance(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            chanceMapper.delete(id);
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
    public JSONObject getChanceById(Integer id) {
        Chance chance;
        try {
            chance = chanceMapper.selectChanceById(id);
        } catch (Exception e) {
            JSONObject resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
            return resp;
        }
        JSONObject resp;
        if (chance == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the chance not exist");
        } else {
            resp = (JSONObject) JSONObject.toJSON(chance);
            resp.put("code", 200);
            resp.put("msg", "select successful");
        }
        return resp;
    }

    @Override
    public JSONObject updateChance(Chance chance) {
        JSONObject resp = new JSONObject();
        try {
            chanceMapper.update(chance.getCh_id(), chance.getCus_id(), chance.getCh_num(), chance.getCh_comment());
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
    public JSONObject showChances(String searchchid,String searchId,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(chanceMapper.showChances(searchchid,searchId));
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
