package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Repository;
import com.example.salecar.pojo.Staff;
import com.example.salecar.service.IrepositoryService;
import com.example.salecar.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/repository")
public class RepositoryController {
    final IrepositoryService service;

    public RepositoryController(IrepositoryService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addRepo")
//    @CrossOrigin(origins = "*")
    public JSONObject addRepo(/*@RequestHeader("token") String token, */@RequestBody Staff repository) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.addRepo(repository);
    }

    @ResponseBody
    @PostMapping("/deleteRepo")
//    @CrossOrigin(origins = "*")
    public JSONObject deleteRepo(/*@RequestHeader("token") String token,*/ @RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        List<Integer> idList = (List<Integer>) req.get("idList");
        int id = (int) req.get("id");
        return service.deleteRepo(id);
    }

    @ResponseBody
    @PostMapping("/updateRepo")
//    @CrossOrigin(origins = "*")
    public JSONObject updateRepo(/*@RequestHeader("token") String token, */@RequestBody Staff repository) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.updateRepo(repository);
    }

    @ResponseBody
    @GetMapping("/showRepos")
   // @CrossOrigin(origins = "*")
    public JSONObject showRepos(/*@RequestHeader("token") String token, */@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                            @RequestParam(required = false) String searchName,@RequestParam(required = false) String searchId) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.showRepos(searchName,searchId,pageNumber, pageSize);
    }

    @ResponseBody
    @GetMapping("/getRepoById")
    //@CrossOrigin(origins = "*")
    public JSONObject getRepoById(/*@RequestHeader("token") String token, */@RequestParam("rep_id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getRepoById(id);
    }

    @ResponseBody
    @GetMapping("/getRepoByAccount")
    //@CrossOrigin(origins = "*")
    public JSONObject getRepoByAccount(/*@RequestHeader("token") String token, */@RequestParam("rep_account") String account) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getRepoByAccount(account);
    }
}
