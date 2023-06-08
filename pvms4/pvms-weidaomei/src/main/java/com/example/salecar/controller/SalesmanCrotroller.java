package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Salesman;
import com.example.salecar.pojo.Staff;
import com.example.salecar.service.IsalesmanService;
import com.example.salecar.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/salesman")
public class SalesmanCrotroller {
    final IsalesmanService service;

    public SalesmanCrotroller(IsalesmanService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addSalesman")
   // @CrossOrigin(origins = "*")
    public JSONObject addSalesman(/*@RequestHeader(value = "token", required = false) String token, */@RequestBody Staff salesman) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.addSalesman(salesman);
    }

    @ResponseBody
    @PostMapping("/deleteSalesman")
    //@CrossOrigin(origins = "*")
    public JSONObject deleteSalesman(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        List<Integer> idList = (List<Integer>) req.get("idList");
        int id = (int) req.get("id");
        return service.deleteSalesman(id);
    }

    @ResponseBody
    @PostMapping("/updateSalesman")
   // @CrossOrigin(origins = "*")
    public JSONObject updateSalesman(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestBody Staff salesman) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.updateSalesman(salesman);
    }

    @ResponseBody
    @GetMapping("/showSalesman")
    //@CrossOrigin(origins = "*")
    public JSONObject showSalesman(/*@RequestHeader(value = "token", required = false) String token, */@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                                                        @RequestParam(required = false) String searchName,@RequestParam(required = false) String searchId) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.showSalesman(searchName,searchId,pageNumber, pageSize);
    }

    @ResponseBody
    @GetMapping("/getSalesmanById")
    //@CrossOrigin(origins = "*")
    public JSONObject getSalesmanById(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestParam("sale_id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getSalesmanById(id);
    }

    @ResponseBody
    @GetMapping("/getSalesmanByAccount")
   // @CrossOrigin(origins = "*")
    public JSONObject getSalesmanByAccount(/*@RequestHeader(value = "token", required = false) String token, */@RequestParam("sale_account") String account) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getSalesmanByAccount(account);
    }
}
