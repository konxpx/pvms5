package com.example.salecar.service;


import com.alibaba.fastjson.JSONObject;
import com.example.salecar.pojo.Repository;
import com.example.salecar.pojo.Staff;

public interface IrepositoryService {
    JSONObject addRepo(Staff repository);

    JSONObject deleteRepo(Integer id);

    JSONObject updateRepo(Staff repository);

    JSONObject showRepos(String searchName,String searchId,Integer pageNumber, Integer pageSize);

    JSONObject getRepoById(int id);

    JSONObject getRepoByAccount(String account);
}
