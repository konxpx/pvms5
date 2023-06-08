package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.RepositoryMapper;
import com.example.salecar.pojo.Repository;
import com.example.salecar.pojo.Staff;
import com.example.salecar.service.IrepositoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

@Service
public class RepositoryServiceimpl implements IrepositoryService {
    final RepositoryMapper repositoryMapper;

    public RepositoryServiceimpl(RepositoryMapper repositoryMapper) {
        this.repositoryMapper = repositoryMapper;
    }

    @Override
    public JSONObject addRepo(Staff repository) {
        JSONObject resp = new JSONObject();
        try {
            Staff repositoryTemp = repositoryMapper.selectByAccount(repository.getS_account());
            if (repositoryTemp != null) {
                resp.put("code", 500);
                resp.put("msg", "the Repo is already exist");
                return resp;
            }
            repositoryMapper.insert(repository.getS_name(), repository.getS_account(),
                    repository.getS_password(), repository.getS_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "addRepo error!");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "addRepo successful");
        return resp;
    }

    @Override
    public JSONObject deleteRepo(Integer id) {
        JSONObject resp = new JSONObject();
        try {
            repositoryMapper.deleteByPrimaryKey(id);

        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "delete Repo error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "delete Repo successful");
        return resp;
    }

    @Override
    public JSONObject updateRepo(Staff repository) {
        JSONObject resp = new JSONObject();
        try {
            repositoryMapper.updateByPrimaryKey(repository.getS_id(), repository.getS_name(), repository.getS_account(),
                    repository.getS_password(), repository.getS_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "update repo error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "update repo successful");
        return resp;
    }

    @Override
    public JSONObject showRepos(String searchName,String searchId,Integer pageNumber, Integer pageSize) {
        JSONObject resp = new JSONObject();
        try {
            PageHelper.startPage(pageNumber, pageSize);
            PageInfo pageInfo = new PageInfo(repositoryMapper.getList(searchName,searchId));
            resp.put("code", 200);
            resp.put("msg", "show repos successful");
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
    public JSONObject getRepoById(int id) {
        try {
            Staff repository = repositoryMapper.selectByPrimaryKey(id);
            if (repository == null) {
                JSONObject resp1 = new JSONObject();
                resp1.put("code", 500);
                resp1.put("msg", "the repo not exist");
                return resp1;
            }
            JSONObject resp = (JSONObject) JSONObject.toJSON(repository);
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
    public JSONObject getRepoByAccount(String account) {
        JSONObject resp;
        Staff repository;
        try {
            repository = repositoryMapper.selectByAccount(account);
        } catch (Exception e) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("error", e.toString());
            return resp;
        }
        if (repository == null) {
            resp = new JSONObject();
            resp.put("code", 500);
            resp.put("msg", "the repo not exist");
            return resp;
        }
        resp = (JSONObject) JSONObject.toJSON(repository);
        resp.put("code", 200);
        return resp;
    }
}
