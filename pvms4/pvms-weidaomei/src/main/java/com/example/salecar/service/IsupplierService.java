package com.example.salecar.service;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Supplier;

public interface IsupplierService {
    JSONObject addSupplier(Supplier supplier);

    JSONObject deleteSupplier(Integer id);

    JSONObject updateSupplier(Supplier supplier);

    JSONObject showSuppliers(String searchName,String searchId,Integer pageNumber, Integer pageSize);

    JSONObject getSupplierById(int id);

    JSONObject getSupplierByName(String name);
}
