package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Customer;
import com.example.salecar.pojo.Repository;
import com.example.salecar.pojo.Salesman;
import com.example.salecar.pojo.Staff;
import com.example.salecar.service.IloginService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping(value = "/index")
public class LoginController {
    final IloginService loginService;

    public LoginController(IloginService loginService) {
        this.loginService = loginService;
    }

    @GetMapping("/begin")
    //@CrossOrigin(origins = "*")
    public String show() {
//        System.out.println("===================>");
        return "index";
    }

    @ResponseBody
    @PostMapping("/customerLogin")
    // @CrossOrigin(origins = "*")
    public JSONObject customerLogin(@RequestBody JSONObject message) {
        String account = (String) message.get("cus_account");
        String password = (String) message.get("cus_password");
        return loginService.cusLogin(account, password);
    }

    @ResponseBody
    @PostMapping("/customerRegister")
    //@CrossOrigin(origins = "*")
    public JSONObject customerRegister(@RequestBody Customer cust) {
        return loginService.cusRegister(cust);
    }

    @ResponseBody
    @PostMapping("/customerChangePwd")
    public JSONObject customerChangePwd(@RequestBody JSONObject message) {
        String account = (String) message.get("cus_account");
        String newPwd = (String) message.get("newPwd");
        String oldPwd = (String) message.get("oldPwd");
        return loginService.cusChangePwd(account, newPwd, oldPwd);
    }

    @ResponseBody
    @PostMapping("/salesmanLogin")
    //@CrossOrigin(origins = "*")
    public JSONObject salesmanLogin(@RequestBody JSONObject message) {
        String account = (String) message.get("sale_account");
        String password = (String) message.get("sale_password");
        return loginService.salesmanLogin(account, password);
    }

    @ResponseBody
    @PostMapping("/salesmanRegister")
    //@CrossOrigin(origins = "*")
    public JSONObject salesmanRegister(@RequestBody Salesman salesman) {
        return loginService.salesmanRegister(salesman);
    }

    @ResponseBody
    @PostMapping("/repoLogin")
    //@CrossOrigin(origins = "*")
    public JSONObject repoLogin(@RequestBody JSONObject message) {
        String account = (String) message.get("rep_account");
        String password = (String) message.get("rep_password");
        return loginService.repoLogin(account, password);
    }

    @ResponseBody
    @PostMapping("/repoRegister")
    //@CrossOrigin(origins = "*")
    public JSONObject repoRegister(@RequestBody Repository repository) {
        return loginService.repoRegister(repository);
    }

    @ResponseBody
    @PostMapping("/salesmanChangePwd")
    //@CrossOrigin(origins = "*")
    public JSONObject salesmanChangePwd(@RequestBody JSONObject message) {
        String account = (String) message.get("sale_account");
        String newPwd = (String) message.get("newPwd");
        String oldPwd = (String) message.get("oldPwd");
        return loginService.salesmanChangePwd(account, newPwd, oldPwd);
    }

    @ResponseBody
    @PostMapping("/repoChangePwd")
    //@CrossOrigin(origins = "*")
    public JSONObject repoChangePwd(@RequestBody JSONObject message) {
        String account = (String) message.get("rep_account");
        String newPwd = (String) message.get("newPwd");
        String oldPwd = (String) message.get("oldPwd");
        return loginService.repoChangePwd(account, newPwd, oldPwd);
    }

    @ResponseBody
    @PostMapping("/managerLogin")
    public JSONObject managerLogin(@RequestBody JSONObject message) {
        String account = (String) message.get("s_account");
        String password = (String) message.get("s_password");
        return loginService.managerLogin(account, password);
    }

    @ResponseBody
    @PostMapping("/managerRegister")
    public JSONObject managerRegister(@RequestBody Staff staff) {
        return loginService.managerRegister(staff);
    }

    @ResponseBody
    @PostMapping("/managerChangePwd")
    public JSONObject managerChangePwd(@RequestBody JSONObject message) {
        String account = (String) message.get("s_account");
        String newPwd = (String) message.get("newPwd");
        String oldPwd = (String) message.get("oldPwd");
        return loginService.managerChangePwd(account, newPwd, oldPwd);
    }
}
