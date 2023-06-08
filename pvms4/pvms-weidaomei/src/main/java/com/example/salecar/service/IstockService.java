package com.example.salecar.service;


import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Stock;

public interface IstockService {
    JSONObject getCarByType(String type);

    //新增车辆
    JSONObject insertCar(Stock car);

    //删除车辆，这里的参数json中的内容是汽车编号列表，其名为idList
    JSONObject deleteCar(Integer id);

    //根据id获取车辆
    JSONObject getCarById(int id);

    //修改车辆信息
    JSONObject updateCar(Stock car);

    //展示所有车辆
    JSONObject showStock(String searchKid,String searchCid,Integer pageNumber, Integer pageSize);
}
