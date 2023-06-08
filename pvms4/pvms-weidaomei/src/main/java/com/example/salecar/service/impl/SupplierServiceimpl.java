package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.SupplierMapper;
import com.example.salecar.pojo.Supplier;
import com.example.salecar.service.IsupplierService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class SupplierServiceimpl implements IsupplierService {

    final SupplierMapper supplierMapper;

    public SupplierServiceimpl(SupplierMapper supplierMapper) {
        this.supplierMapper = supplierMapper;
    }

    @Override
    public JSONObject addSupplier(Supplier supplier) {
        JSONObject resp = new JSONObject();
        try {
            /*Supplier supplier1 = supplierMapper.selectByName(supplier.getSup_name());
            if (supplier1 != null) {
                resp.put("code", 500);
                resp.put("msg", "the supplier is already exist");
                return resp;
            }*/
            supplierMapper.insert(supplier.getSup_name(), supplier.getSup_address(), supplier.getSup_phone(), supplier.getSup_person());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "addSupplier error!");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "addSupplier successful");
        return resp;
    }

    @Override
    public JSONObject deleteSupplier(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            supplierMapper.deleteByPrimaryKey(id);
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "delete supplier error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "delete supplier successful");
        return resp;
    }

    @Override
    public JSONObject updateSupplier(Supplier supplier) {
        JSONObject resp = new JSONObject();
        try {
            supplierMapper.updateByPrimaryKey(supplier.getSup_id(), supplier.getSup_name(), supplier.getSup_address(),
                    supplier.getSup_phone(), supplier.getSup_person());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "update supplier error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "update supplier successful");
        return resp;
    }

    @Override
    public JSONObject showSuppliers(String searchName,String searchId,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(supplierMapper.getSupplierList(searchName,searchId));
            resp.put("code", 200);
            resp.put("msg", "show suppliers successful");
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
    public JSONObject getSupplierById(int id) {
        try {
            Supplier supplier = supplierMapper.selectByPrimaryKey(id);
            if (supplier == null) {
                JSONObject resp1 = new JSONObject();
                resp1.put("code", 500);
                resp1.put("msg", "the supplier not exist");
                return resp1;
            }
            JSONObject resp = (JSONObject) JSONObject.toJSON(supplier);
            resp.put("code", 200);
            resp.put("msg", "get successful");
            return resp;
        } catch (Exception e) {
            JSONObject resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
    }

    @Override
    public JSONObject getSupplierByName(String name) {
        JSONObject resp = new JSONObject();
        PageInfo pageInfo;
        try {
            pageInfo = new PageInfo(supplierMapper.selectByName(name));
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (pageInfo.getTotal() == 0) {
            resp.put("code", 500);
            resp.put("msg", "the supplier not exist");
            return resp;
        }
        resp.put("code", 200);
        resp.put("data", pageInfo.getList());
        resp.put("count", pageInfo.getTotal());
        return resp;
    }
}
