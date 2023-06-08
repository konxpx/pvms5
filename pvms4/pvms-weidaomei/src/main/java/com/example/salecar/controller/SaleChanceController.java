package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Chance;
import com.example.salecar.service.IchanceService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/chance")
public class SaleChanceController {
    final IchanceService service;

    public SaleChanceController(IchanceService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("addChance")
    //@CrossOrigin(origins = "*")
    public JSONObject addChance(@RequestBody Chance chance) {
        return service.addChance(chance);
    }

    @ResponseBody
    @PostMapping("deleteChance")
   // @CrossOrigin(origins = "*")
    public JSONObject deleteChance(@RequestBody JSONObject message) {
        int id = (int) message.get("id");
        return service.deleteChance(id);
    }

    @ResponseBody
    @GetMapping("getChanceById")
    //@CrossOrigin(origins = "*")
    public JSONObject getChanceById(@RequestParam("id") int id) {
        return service.getChanceById(id);
    }

    @ResponseBody
    @PostMapping("updateChance")
    //@CrossOrigin(origins = "*")
    public JSONObject updateChance(@RequestBody Chance chance) {
        return service.updateChance(chance);
    }

    @ResponseBody
    @GetMapping("showChances")
    //@CrossOrigin(origins = "*")
    public JSONObject showChances(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize ,
                                  @RequestParam(required = false) String searchchid,@RequestParam(required = false) String searchId) {
        return service.showChances(searchchid,searchId,pageNumber, pageSize);
    }
}
