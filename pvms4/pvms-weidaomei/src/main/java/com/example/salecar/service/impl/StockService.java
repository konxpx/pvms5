package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.StockMapper;
import com.example.salecar.pojo.Stock;
import com.example.salecar.service.IstockService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StockService implements IstockService {
    final StockMapper stockMapper;

    public StockService(StockMapper stockMapper) {
        this.stockMapper = stockMapper;
    }

    @Override
    public JSONObject getCarByType(String type) {
        JSONObject resp = new JSONObject();
        List<Stock> cars;
        try {
            cars = stockMapper.getCarByType(type);
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (cars.size() == 0) {
            resp.put("code", 500);
            resp.put("msg", "cars of the type not exist");
            return resp;
        }
        PageInfo pageInfo = new PageInfo(cars);
        resp.put("code", 200);
        resp.put("data", pageInfo.getList());
        resp.put("count", pageInfo.getTotal());
        return resp;
    }

    @Override
    public JSONObject insertCar(Stock car) {
        JSONObject resp = new JSONObject();
        try {
            stockMapper.insert(car.getCar_id(), car.getStock_intime(), car.getStock_outtime());
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
    public JSONObject deleteCar(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            stockMapper.deleteByPrimaryKey(id);
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
    public JSONObject getCarById(int id) {
        JSONObject resp;
        Stock car;
        try {
            car = stockMapper.selectByPrimaryKey(id);
        } catch (Exception e) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (car == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the car not exist");
            return resp;
        }
        resp = (JSONObject) JSONObject.toJSON(car);
        resp.put("code", 200);
        return resp;
    }

    //修改汽车信息
    @Override
    public JSONObject updateCar(Stock car) {
        JSONObject resp = new JSONObject();
        try {
            stockMapper.updateByPrimaryKey(car.getStock_id(), car.getCar_id(), car.getStock_intime(), car.getStock_outtime());
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

    //获取库存中所有车辆
    @Override
    public JSONObject showStock(String searchKid,String searchCid,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(stockMapper.showStock(searchKid,searchCid));
            resp.put("code", 200);
            resp.put("msg", "show cars successful");
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
