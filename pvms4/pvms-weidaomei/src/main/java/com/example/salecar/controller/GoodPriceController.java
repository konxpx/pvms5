package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Goodprice;
import com.example.salecar.service.IgoodPriceService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/carprice")
public class GoodPriceController {
    final IgoodPriceService service;

    public GoodPriceController(IgoodPriceService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addPrice")
    //@CrossOrigin(origins = "*")
    public JSONObject addPrice(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestBody Goodprice goodprice) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.addPrice(goodprice);
    }

    @ResponseBody
    @PostMapping("/deletePrice")
    //@CrossOrigin(origins = "*")
    public JSONObject deletePrice(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        int id = (int) req.get("id");
        return service.deletePrice(id);
    }

    @ResponseBody
    @PostMapping("/updatePrice")
    //@CrossOrigin(origins = "*")
    public JSONObject updatePrice(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestBody Goodprice goodprice) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.updatePrice(goodprice);
    }

    @ResponseBody
    @GetMapping("/showPrice")
//    @CrossOrigin(origins = "*")
    public JSONObject showPrice(/*@RequestHeader("token") String token, */@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                              @RequestParam(required = false) String searchpid,@RequestParam(required = false) String searchcid) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.showPrice(searchpid,searchcid,pageNumber, pageSize);
    }


    @ResponseBody
    @GetMapping("/getPriceById")
    //@CrossOrigin(origins = "*")
    public JSONObject getPriceById(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestParam("id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getPriceById(id);
    }
}
