package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Staff;
import com.example.salecar.service.IguideService;
import com.example.salecar.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/guide")
public class GuideController {
    final IguideService service;

    public GuideController(IguideService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addGuide")
    //@CrossOrigin(origins = "*")
    public JSONObject addGuide(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestBody Staff guide) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.addGuide(guide);
    }

    @ResponseBody
    @PostMapping("/deleteGuide")
    //@CrossOrigin(origins = "*")
    public JSONObject deleteGuide(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        int id = (int) req.get("id");
        return service.deleteGuide(id);
    }

    @ResponseBody
    @PostMapping("/updateGuide")
    //@CrossOrigin(origins = "*")
    public JSONObject updateGuide(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestBody Staff guide) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.updateGuide(guide);
    }

    @ResponseBody
    @GetMapping("/showGuides")
    //@CrossOrigin(origins = "*")
    public JSONObject showGuides(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                                                     @RequestParam(required = false) String searchName,@RequestParam(required = false) String searchId) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.showGuides(searchName,searchId,pageNumber, pageSize);
    }

    @ResponseBody
    @GetMapping("/getGuideById")
    //@CrossOrigin(origins = "*")
    public JSONObject getGuideById(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestParam("id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getGuideById(id);
    }

    @ResponseBody
    @GetMapping("/getSalesmanByAccount")
    //@CrossOrigin(origins = "*")
    public JSONObject getSalesmanByAccount(/*@RequestHeader(value = "token", required = false) String token,*/ @RequestParam("account") String account) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getGuideByAccount(account);
    }
}
