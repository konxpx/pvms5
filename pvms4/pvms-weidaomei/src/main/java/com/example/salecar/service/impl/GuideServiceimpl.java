package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.GuideMapper;
import com.example.salecar.pojo.Staff;
import com.example.salecar.service.IguideService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class GuideServiceimpl implements IguideService {
    final GuideMapper guideMapper;

    public GuideServiceimpl(GuideMapper guideMapper) {
        this.guideMapper = guideMapper;
    }


    @Override
    public JSONObject addGuide(Staff guide) {
        JSONObject resp = new JSONObject();
        try {
            Staff guide1 = guideMapper.selectByAccount(guide.getS_account());
            if (guide1 != null) {
                resp.put("code", 500);
                resp.put("msg", "the guide is already exist");
                return resp;
            }
            guideMapper.insert(guide.getS_name(), guide.getS_account(), guide.getS_password(), guide.getS_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "add guide error!");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "add guide successful");
        return resp;
    }

    @Override
    public JSONObject deleteGuide(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            guideMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "delete error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "delete successful");
        return resp;
    }

    @Override
    public JSONObject updateGuide(Staff guide) {
        JSONObject resp = new JSONObject();
        try {
            guideMapper.updateByPrimaryKey(guide.getS_id(), guide.getS_name(), guide.getS_account(), guide.getS_password(), guide.getS_phone());
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
    public JSONObject showGuides(String searchName,String searchId,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(guideMapper.getGuideList(searchName,searchId));
            resp.put("code", 200);
            resp.put("msg", "show guides successful");
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }

    @Override
    public JSONObject getGuideById(Integer id) {
        try {
            Staff guide = guideMapper.selectByPrimaryKey(id);
            if (guide == null) {
                JSONObject resp1 = new JSONObject();
                resp1.put("code", 500);
                resp1.put("msg", "the guide not exist");
                return resp1;
            }
            JSONObject resp = (JSONObject) JSONObject.toJSON(guide);
            resp.put("code", 200);
            resp.put("msg", "get successful");
            return resp;
        } catch (Exception e) {
            JSONObject resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
    }

    @Override
    public JSONObject getGuideByAccount(String account) {
        JSONObject resp;
        Staff guide;
        try {
            guide = guideMapper.selectByAccount(account);
        } catch (Exception e) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (guide == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the guide not exist");
            return resp;
        }
        resp = (JSONObject) JSONObject.toJSON(guide);
        resp.put("code", 200);
        return resp;
    }
}
