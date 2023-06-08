package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Supplier;
import com.example.salecar.service.IsupplierService;
import com.example.salecar.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/supplier")
public class SupplierController {
    final IsupplierService service;

    public SupplierController(IsupplierService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addSupplier")
//    @CrossOrigin(origins = "*")
    public JSONObject addSupplier(/*@RequestHeader("token") String token, */@RequestBody Supplier supplier) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.addSupplier(supplier);
    }

    @ResponseBody
    @PostMapping("/deleteSupplier")
//    @CrossOrigin(origins = "*")
    public JSONObject deleteSupplier(/*@RequestHeader("token") String token, */@RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        int id = (int) req.get("id");
        return service.deleteSupplier(id);
    }

    @ResponseBody
    @PostMapping("/updateSupplier")
//    @CrossOrigin(origins = "*")
    public JSONObject updateSupplier(/*@RequestHeader("token") String token,*/@RequestBody Supplier supplier) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.updateSupplier(supplier);
    }

    @ResponseBody
    @GetMapping("/showSuppliers")
//    @CrossOrigin(origins = "*")
    public JSONObject showSuppliers(/*@RequestHeader("token") String token,*/ @RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                              @RequestParam(required = false) String searchName,@RequestParam(required = false) String searchId) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.showSuppliers(searchName,searchId,pageNumber, pageSize);
    }

    @ResponseBody
    @GetMapping("/getSupplierById")
//    @CrossOrigin(origins = "*")
    public JSONObject getSupplierById(/*@RequestHeader("token") String token, */@RequestParam("sup_id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getSupplierById(id);
    }

    @ResponseBody
    @GetMapping("/getSupplierByName")
//    @CrossOrigin(origins = "*")
    public JSONObject getSupplierByName(/*@RequestHeader("token") String token, */@RequestParam("sup_name") String name) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getSupplierByName(name);
    }
}
