package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Good;

public interface IgoodService {
    JSONObject addCar(Good good);

    JSONObject deleteCar(Integer id);

    JSONObject updateCar(Good good);

    JSONObject showCars(String serchcarid,String searchsid,Integer pageNumber, Integer pageSize);

    JSONObject getCarById(Integer id);


}
