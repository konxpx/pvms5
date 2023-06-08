package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.service.ichartspieService;
import org.springframework.web.bind.annotation.*;
import com.example.salecar.service.ichartService;
import com.example.salecar.service.ichartspieService;

@RestController
@RequestMapping("/charts")
public class chartsController {
    final ichartService ichartService;

    public chartsController(com.example.salecar.service.ichartService ichartService) {
        this.ichartService = ichartService;
    }

    @ResponseBody
    @GetMapping("/showquantity")
    public JSONObject showquantity(){
        //System.out.println( ichartService.showquantity());
        return ichartService.showquantity();
    }

    @ResponseBody
    @GetMapping("/showstaff")
    public JSONObject showstaff(){
//        System.out.println(ichartService.showstaff());
        return ichartService.showstaff();
    }
    @ResponseBody
    @GetMapping("/showorder")
    public JSONObject showordercar(){
        return ichartService.showordercar();
    }
    @ResponseBody
    @GetMapping("/showmoney")
    public JSONObject showmoney(){
        return ichartService.showmoney();
    }

}
