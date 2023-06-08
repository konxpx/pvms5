package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Chance;

public interface IchanceService {
    JSONObject addChance(Chance chance);

    JSONObject deleteChance(Integer id);

    JSONObject getChanceById(Integer id);

    JSONObject updateChance(Chance chance);

    JSONObject showChances(String searchchid,String searchId,Integer pageNumber, Integer pageSize);
}
