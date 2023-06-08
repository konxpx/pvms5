package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Purorder;
import com.example.salecar.service.IpurService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/purorder")
public class PurController {
    final IpurService service;

    public PurController(IpurService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("addPurorder")
//    @CrossOrigin(origins = "*")
    public JSONObject addPurorder(@RequestBody Purorder purorder) {
        return service.addPurorder(purorder);
    }

    @ResponseBody
    @PostMapping("deletePurorder")
//    @CrossOrigin(origins = "*")
    public JSONObject deletePurorder(@RequestBody JSONObject message) {
        int id = (int) message.get("id");
        return service.deletePurorder(id);
    }

    @ResponseBody
    @GetMapping("getPurorderById")
//    @CrossOrigin(origins = "*")
    public JSONObject getPurorderById(@RequestParam("id") int id) {
        return service.getPurorderById(id);
    }

    @ResponseBody
    @PostMapping("updatePurorder")
//    @CrossOrigin(origins = "*")
    public JSONObject updatePurorder(@RequestBody Purorder purorder) {
        return service.updatePurorder(purorder);
    }

    @ResponseBody
    @GetMapping("showPurorders")
//    @CrossOrigin(origins = "*")
    public JSONObject showPurorders(@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                    @RequestParam(required = false) String searchPid,@RequestParam(required = false) String searchCid) {
        return service.showPurorders(searchPid,searchPid,pageNumber, pageSize);
    }
}
