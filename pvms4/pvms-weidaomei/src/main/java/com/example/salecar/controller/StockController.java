package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Stock;
import com.example.salecar.service.IstockService;
import com.example.salecar.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/stock")
public class StockController {
    final IstockService istockService;

    public StockController(IstockService istockService) {
        this.istockService = istockService;
    }

    @ResponseBody
    @PostMapping("/insertCar")
//    @CrossOrigin(origins = "*")
    public JSONObject insertCar(/*@RequestHeader("token") String token,*/ @RequestBody Stock car) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return istockService.insertCar(car);
    }

    @ResponseBody
    @PostMapping("/deleteCar")
//    @CrossOrigin(origins = "*")
    public JSONObject deleteCar(/*@RequestHeader("token") String token,*/ @RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        int id = (int) req.get("id");
        return istockService.deleteCar(id);
    }

    //根据id获取车辆
    @ResponseBody
    @GetMapping("/getCarById")
//    @CrossOrigin(origins = "*")
    public JSONObject getCarById(/*@RequestHeader("token") String token,*/ @RequestParam("car_id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return istockService.getCarById(id);
    }

    @ResponseBody
    @GetMapping("/getCarsByType")
//    @CrossOrigin(origins = "*")
    public JSONObject getCarsByType(/*@RequestHeader("token") String token, */@RequestParam("car_type") String type) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return istockService.getCarByType(type);
    }

    @ResponseBody
    @PostMapping("/updateCar")
//    @CrossOrigin(origins = "*")
    //修改车辆信息
    public JSONObject updateCar(/*@RequestHeader("token") String token, */@RequestBody Stock car) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return istockService.updateCar(car);
    }


    @ResponseBody
    @GetMapping("/showStock")
//    @CrossOrigin(origins = "*")
    //展示所有车辆
    public JSONObject showStock(/*@RequestHeader("token") String token,*/ @RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                         @RequestParam(required = false) String searchKid,@RequestParam(required = false) String searchCid) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return istockService.showStock(searchKid,searchCid,pageNumber, pageSize);
    }
}
