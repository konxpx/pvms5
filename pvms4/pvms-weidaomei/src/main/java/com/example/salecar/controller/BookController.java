package com.example.salecar.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Book;
import com.example.salecar.service.IbookService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {
    final IbookService service;

    public BookController(IbookService service) {
        this.service = service;
    }

    @ResponseBody
    @PostMapping("/addBook")
   // @CrossOrigin(origins = "*")
    public JSONObject addBook(@RequestBody Book book) {
        JSONObject jsonObject = service.addBook(book);
        return jsonObject;
    }

    @ResponseBody
    @PostMapping("/deleteBook")
    //@CrossOrigin(origins = "*")
    //暂时将批量删除改为单项删除
    public JSONObject deleteBook(@RequestParam(required = true)Integer idList) {
        return service.deleteBook(idList);
    }

    @ResponseBody
    @PostMapping("/updateBook")
   // @CrossOrigin(origins = "*")
    public JSONObject updateBook(@RequestBody Book book) {
        return service.updateBook(book);
    }

    @ResponseBody
    @GetMapping("/showBook")
    //@CrossOrigin(origins = "*")
    //后两项不是必须项，搜索时可传参
    public JSONObject showBook(@RequestParam(defaultValue = "1") Integer page, @RequestParam(defaultValue = "10") Integer size,
                                    @RequestParam(required = false) String searchCusid,
                                    @RequestParam(required = false) String searchStaffid) {
        return service.showBook(searchCusid,searchStaffid,page,size);
    }

    @ResponseBody
    @GetMapping("/getBookById")
   // @CrossOrigin(origins = "*")
    public JSONObject getBookById(@RequestParam("cus_id") int id) {
        return service.getBookById(id);
    }

//    @ResponseBody
//    @GetMapping("/getBookByAccount")
//    public JSONObject getBookByAccount(@RequestParam("cus_account") String account) {
//        return service.getBookByAccount(account);
//    }

}
