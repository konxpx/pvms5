package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.service.ichartspieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/charts")
public class chartspieController {
    final ichartspieService ichartspieService;

    public chartspieController(com.example.salecar.service.ichartspieService ichartspieService) {
        this.ichartspieService = ichartspieService;
    }

    @ResponseBody
    @GetMapping("/showstate")
    public JSONObject showstate(){
        System.out.println(ichartspieService.showstate());
        return ichartspieService.showstate();
    }
    @ResponseBody
    @GetMapping("/showbook")
    public JSONObject showbook(){
        return ichartspieService.showbook();
    }
}
