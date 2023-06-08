package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Purorder;

public interface IpurService {
    JSONObject addPurorder(Purorder purorder);

    JSONObject deletePurorder(Integer id);

    JSONObject getPurorderById(Integer id);

    JSONObject updatePurorder(Purorder purorder);

    JSONObject showPurorders(String searchPid,String searchCid,Integer pageNumber, Integer pageSize);
}
