package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Staff;

public interface IguideService {
    JSONObject addGuide(Staff guide);

    JSONObject deleteGuide(Integer id);

    JSONObject updateGuide(Staff guide);

    JSONObject showGuides(String searchName,String searchId,Integer pageNumber, Integer pageSize);

    JSONObject getGuideById(Integer id);

    JSONObject getGuideByAccount(String account);
}
