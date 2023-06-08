package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Order;
import com.example.salecar.service.IorderService;
import com.example.salecar.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/order")
public class OrderController {
    final IorderService service;

    public OrderController(IorderService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addOrder")
 //   @CrossOrigin(origins = "*")
    public JSONObject addOrder(/*@RequestHeader("token") String token, */@RequestBody Order order) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.addOrder(order);
    }

    @ResponseBody
    @PostMapping("/deleteOrder")
 //   @CrossOrigin(origins = "*")
    public JSONObject deleteOrder(/*@RequestHeader("token") String token,*/ @RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        int id = (int) req.get("id");
        return service.deleteOrder(id);
    }

    @ResponseBody
    @PostMapping("/updateOrder")
 //   @CrossOrigin(origins = "*")
    public JSONObject updateOrder(/*@RequestHeader("token") String token,*/ @RequestBody Order order) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.updateOrder(order);
    }

    @ResponseBody
    @GetMapping("/getOrderById")
 //   @CrossOrigin(origins = "*")
    public JSONObject getOrderById(/*@RequestHeader("token") String token,*/ @RequestParam("order_id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getOrderById(id);
    }

    @ResponseBody
    @GetMapping("/getOrderByCustomer")
  //  @CrossOrigin(origins = "*")
    public JSONObject getOrderByCustomer(/*@RequestHeader("token") String token,*/ @RequestParam("cus_name") String cus_name) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getOrderByCustomer(cus_name);
    }

    @ResponseBody
    @GetMapping("/showOrders")
  //  @CrossOrigin(origins = "*")
    public JSONObject showOrders(/*@RequestHeader("token") String token, */@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                           @RequestParam(required = false) String searchoid,@RequestParam(required = false) String searchcusId){
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.showOrders(searchoid,searchcusId,pageNumber, pageSize);
    }

    /*@ResponseBody
    @GetMapping("/getOrdersByDate")
    @CrossOrigin(origins = "*")
    public JSONObject getOrdersByDate(@RequestHeader("token") String token, @RequestParam("cus_date") String date) {
        if (!TokenUtils.checkToken(token)) {
            JSONObject resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "token invalid");
            return resp;
        }
        return service.getOrdersByDate(date);
    }*/
}
