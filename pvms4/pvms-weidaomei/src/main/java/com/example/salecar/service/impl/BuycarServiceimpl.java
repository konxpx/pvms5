package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.BookMapper;
import com.example.salecar.dao.GoodMapper;
import com.example.salecar.service.IbuycarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class BuycarServiceimpl implements IbuycarService {
    final BookMapper bookMapper;
    final GoodMapper goodMapper;

    public BuycarServiceimpl(BookMapper bookMapper, GoodMapper goodMapper) {
        this.bookMapper = bookMapper;
        this.goodMapper = goodMapper;
    }

    @Override
    public JSONObject getCarList(String searchcarid, String searchsid, Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(goodMapper.showgoods(searchcarid, searchsid));
            resp.put("code", 200);
            resp.put("msg", "show cars successful");
            resp.put("data", pageInfo.getList());
            resp.put("count", pageInfo.getTotal());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "select error");
            resp.put("error", e.toString());
        }
        return resp;
    }

    @Override
    public JSONObject preBook(int cus_id, int car_id, int s_id, String book_time, String book_addr) {
        JSONObject resp = new JSONObject();
        try {
            bookMapper.insert(cus_id, car_id, s_id, book_time, book_addr);
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            resp.put("msg", "insert error");
        }
        resp.put("code", 200);
        resp.put("msg", "insert successful");
        return resp;
    }
}
