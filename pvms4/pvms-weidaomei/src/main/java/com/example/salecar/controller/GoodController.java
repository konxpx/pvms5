package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Good;
import com.example.salecar.service.IgoodService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/car")
public class GoodController {
    final IgoodService service;

    public GoodController(IgoodService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addCar")
   // @CrossOrigin(origins = "*")
    public JSONObject addCar(/*@RequestHeader("token") String token, */@RequestBody Good good) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.addCar(good);
    }

    @ResponseBody
    @PostMapping("/deleteCar")
    //@CrossOrigin(origins = "*")
    public JSONObject deleteCar(/*@RequestHeader("token") String token,*/ @RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        int id = (int) req.get("id");
        return service.deleteCar(id);
    }

    @ResponseBody
    @PostMapping("/updateCar")
   // @CrossOrigin(origins = "*")
    public JSONObject updateCar(/*@RequestHeader("token") String token, */@RequestBody Good good) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.updateCar(good);
    }

    @ResponseBody
    @GetMapping("/getCarById")
    //@CrossOrigin(origins = "*")
    public JSONObject getCarById(/*@RequestHeader("token") String token,*/ @RequestParam("car_id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }

        return service.getCarById(id);
    }

    @ResponseBody
    @GetMapping("/showCars")
    //@CrossOrigin(origins = "*")
    public JSONObject showCars(/*@RequestHeader("token") String token, */@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                         @RequestParam(required = false) String searchcarid,@RequestParam(required = false) String searchsid) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }

        return service.showCars(searchcarid,searchsid,pageNumber, pageSize);
    }
}
