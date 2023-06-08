package com.example.salecar.controller;
import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Customer;
import com.example.salecar.service.IcustomerService;
import com.example.salecar.utils.TokenUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/customer")
public class  CustomerController {
    final IcustomerService service;

    public CustomerController(IcustomerService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addCustomer")
    //@CrossOrigin(origins = "*")
    public JSONObject addCustomer(/*@RequestHeader("token") String token,*/ @RequestBody Customer customer) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.addCustomer(customer);
    }

    @ResponseBody
    @PostMapping("/deleteCustomer")
    //@CrossOrigin(origins = "*")
    public JSONObject deleteCustomer(/*@RequestHeader("token") String token, */@RequestBody JSONObject req) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }

        int id = (int) req.get("id");
        return service.deleteCustomer(id);
    }

    @ResponseBody
    @PostMapping("/updateCustomer")
//    @CrossOrigin(origins = "*")
    public JSONObject updateCustomer(/*@RequestHeader("token") String token, */@RequestBody Customer customer) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }

        return service.updateCustomer(customer);
    }

    @ResponseBody
    @GetMapping("/showCustomers")
   // @CrossOrigin(origins = "*")
    public JSONObject showCustomers(/*@RequestHeader("token") String token, */@RequestParam("pageNumber") Integer pageNumber, @RequestParam("pageSize") Integer pageSize,
                                                                              @RequestParam(required = false) String searchName,@RequestParam(required = false) String searchId) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.showCustomers(searchName,searchId,pageNumber, pageSize);
    }

    @ResponseBody
    @GetMapping("/getCustomerById")
//    @CrossOrigin(origins = "*")
    public JSONObject getCustomerById(/*@RequestHeader("token") String token,*/@RequestParam("cus_id") int id) {
//        if (!TokenUtils.checkToken(token)) {
//           JSONObject resp = new JSONObject();
//           resp.put("code", 500);
//           resp.put("msg", "token invalid");
//            return resp;
//       }
        return service.getCustomerById(id);
    }

    @ResponseBody
    @GetMapping("/getCustomerByAccount")
//    @CrossOrigin(origins = "*")
    public JSONObject getCustomerByAccount(/*@RequestHeader("token") String token,*/ @RequestParam("cus_account") String account) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getCustomerByAccount(account);
    }

    @ResponseBody
    @GetMapping("/getCustomerByPhone")
//    @CrossOrigin(origins = "*")
    public JSONObject getCustomerByPhone(/*@RequestHeader("token") String token,*/ @RequestParam("cus_phone") String phone) {
//        if (!TokenUtils.checkToken(token)) {
//            JSONObject resp = new JSONObject();
//            resp.put("code", 500);
//            resp.put("msg", "token invalid");
//            return resp;
//        }
        return service.getCustomerByPhone(phone);
    }
}
