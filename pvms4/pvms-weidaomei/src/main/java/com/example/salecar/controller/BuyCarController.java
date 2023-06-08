package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.service.IbuycarService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/buyCar")
public class BuyCarController {
    final IbuycarService service;

    public BuyCarController(IbuycarService service) {
        this.service = service;
    }

    @ResponseBody
    @GetMapping("/getCarList")
    public JSONObject getCarList(@RequestParam(required = false) String searchcarid,
                                 @RequestParam(required = false) String searchsid,
                                 @RequestParam(defaultValue = "1") Integer pageNumber,
                                 @RequestParam(defaultValue = "10") Integer pageSize) {
        return service.getCarList(searchcarid, searchsid, pageNumber, pageSize);
    }

    @ResponseBody
    @PostMapping("/preBook")
    public JSONObject preBook(@RequestBody JSONObject message) {
        int cus_id;
        int car_id;
        int s_id;
        String book_time;
        String book_addr;
        cus_id = (int) message.get("cus_id");
        car_id = (int) message.get("car_id");
        s_id = (int) message.get("s_id");
        book_time = (String) message.get("book_time");
        book_addr = (String) message.get("book_addr");
        return service.preBook(cus_id, car_id, s_id, book_time, book_addr);
    }
}
