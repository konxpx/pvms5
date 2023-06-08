package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;

public interface IbuycarService {
    JSONObject getCarList(String searchcarid, String searchsid, Integer pageNumber, Integer pageSize);

    JSONObject preBook(int cus_id, int car_id, int s_id, String book_time, String book_addr);
}
