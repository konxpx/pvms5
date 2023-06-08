package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Goodprice;

public interface IgoodPriceService {
    JSONObject addPrice(Goodprice goodprice);

    JSONObject deletePrice(Integer id);

    JSONObject getPriceById(Integer id);

    JSONObject updatePrice(Goodprice goodprice);

    JSONObject showPrice(String searchpid,String searchcid,Integer pageNumber, Integer pageSize);
}
