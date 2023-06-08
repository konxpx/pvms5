package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.SalesmanMapper;
import com.example.salecar.pojo.Salesman;
import com.example.salecar.pojo.Staff;
import com.example.salecar.service.IsalesmanService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class SalesmanServiceimpl implements IsalesmanService {
    final SalesmanMapper salesmanMapper;

    public SalesmanServiceimpl(SalesmanMapper salesmanMapper) {
        this.salesmanMapper = salesmanMapper;
    }

    @Override
    public JSONObject addSalesman(Staff salesman) {
        JSONObject resp = new JSONObject();
        try {
            Staff salesman1 = salesmanMapper.selectByAccount(salesman.getS_account());
            if (salesman1 != null) {
                resp.put("code", 500);
                resp.put("msg", "the salesman is already exist");
                return resp;
            }
            salesmanMapper.insert(salesman.getS_name(), salesman.getS_account(), salesman.getS_password(), salesman.getS_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "addSalesman error!");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "addSalesman successful");
        return resp;
    }

    @Override
    public JSONObject deleteSalesman(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            salesmanMapper.deleteByPrimaryKey(id);

        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "delete salesman error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "delete salesman successful");
        return resp;
    }

    @Override
    public JSONObject updateSalesman(Staff salesman) {
        JSONObject resp = new JSONObject();
        try {
            salesmanMapper.updateByPrimaryKey(salesman.getS_id(), salesman.getS_name(), salesman.getS_account(),
                    salesman.getS_password(), salesman.getS_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "update salesman error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "update salesman successful");
        return resp;
    }

    @Override
    public JSONObject showSalesman(String searchName,String searchId,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(salesmanMapper.getSalesmanList(searchName,searchId));
            resp.put("code", 200);
            resp.put("msg", "show salesmans successful");
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
    public JSONObject getSalesmanById(int id) {
        try {
            Staff salesman = salesmanMapper.selectByPrimaryKey(id);
            if (salesman == null) {
                JSONObject resp1 = new JSONObject();
                resp1.put("code", 500);
                resp1.put("msg", "the salesman not exist");
                return resp1;
            }
            JSONObject resp = (JSONObject) JSONObject.toJSON(salesman);
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
    public JSONObject getSalesmanByAccount(String account) {
        JSONObject resp;
        Staff salesman;
        try {
            salesman = salesmanMapper.selectByAccount(account);
        } catch (Exception e) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (salesman == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the salesman not exist");
            return resp;
        }
        resp = (JSONObject) JSONObject.toJSON(salesman);
        resp.put("code", 200);
        return resp;
    }
}
