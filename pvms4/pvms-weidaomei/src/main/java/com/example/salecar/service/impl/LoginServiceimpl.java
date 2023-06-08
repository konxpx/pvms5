package com.example.salecar.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.example.salecar.dao.CustomerMapper;
import com.example.salecar.dao.ManagerMapper;
import com.example.salecar.dao.RepositoryMapper;
import com.example.salecar.dao.SalesmanMapper;
import com.example.salecar.pojo.Customer;
import com.example.salecar.pojo.Repository;
import com.example.salecar.pojo.Salesman;
import com.example.salecar.pojo.Staff;
import com.example.salecar.service.IloginService;
import com.example.salecar.utils.TokenUtils;
import org.springframework.stereotype.Service;

@Service
public class LoginServiceimpl implements IloginService {
    final CustomerMapper custMapper;
    final SalesmanMapper salesmanMapper;

    final RepositoryMapper repositoryMapper;

    final ManagerMapper managerMapper;

    public LoginServiceimpl(CustomerMapper custMapper, SalesmanMapper salesmanMapper, RepositoryMapper repositoryMapper, ManagerMapper managerMapper) {
        this.custMapper = custMapper;
        this.salesmanMapper = salesmanMapper;
        this.repositoryMapper = repositoryMapper;
        this.managerMapper = managerMapper;
    }

    @Override
    public JSONObject cusLogin(String username, String password) {
        Customer customer = custMapper.selectByAccount(username);
        JSONObject resp = new JSONObject();
        if (customer == null) {
            resp.put("code", 500);
            resp.put("msg", "user not exists!");
            return resp;
        }
        if (customer.getCus_password().equals(password)) {
            String token = TokenUtils.createToken(username);
            resp.put("code", 200);
            resp.put("msg", "login successful!");
            resp.put("account", username);
            resp.put("token", token);
        } else {
            resp.put("code", 500);
            resp.put("msg", "password fault!");
        }
        return resp;
    }

    @Override
    public JSONObject cusRegister(Customer customer) {
        String account = customer.getCus_account();
        Customer custm = custMapper.selectByAccount(account);
        JSONObject resp = new JSONObject();
        if (custm != null) {
            resp.put("code", 500);
            resp.put("msg", "the account is already exist");
            return resp;
        }
        if (customer.getCus_name() == null) {
            customer.setCus_name(account);
        }
        try {
            custMapper.insert(customer.getCus_name(), account, customer.getCus_password(), customer.getCus_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "insert error");
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "Register successful!");
        return resp;
    }

    @Override
    public JSONObject salesmanLogin(String username, String password) {
        JSONObject resp = new JSONObject();
        Staff salesman = salesmanMapper.selectByAccount(username);
        if (salesman == null) {
            resp.put("code", 500);
            resp.put("msg", "the salesman not exist");
            return resp;
        }
        if (salesman.getS_password().equals(password)) {
            String token = TokenUtils.createToken(username);
            resp.put("code", 200);
            resp.put("msg", "login successful!");
            resp.put("account", username);
            resp.put("token", token);
        } else {
            resp.put("code", 500);
            resp.put("msg", "password fault!");
        }
        return resp;
    }

    @Override
    public JSONObject salesmanRegister(Salesman salesman) {
        JSONObject resp = new JSONObject();
        String account = salesman.getSale_account();
        Staff result = salesmanMapper.selectByAccount(account);
        if (result != null) {
            resp.put("code", 500);
            resp.put("msg", "the account is already exist");
            return resp;
        }
        if (salesman.getSale_name() == null) {
            salesman.setSale_name(account);
        }
        try {
            salesmanMapper.insert(salesman.getSale_name(), salesman.getSale_account(), salesman.getSale_password(), salesman.getSale_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "insert error");
            resp.put("error", e.toString());
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "Register successful!");
        return resp;
    }

    @Override
    public JSONObject repoLogin(String username, String password) {
        Staff repository = repositoryMapper.selectByAccount(username);
        JSONObject resp = new JSONObject();
        if (repository == null) {
            resp.put("code", 500);
            resp.put("msg", "user not exists!");
            return resp;
        }
        if (repository.getS_password().equals(password)) {
            String token = TokenUtils.createToken(username);
            resp.put("code", 200);
            resp.put("msg", "login successful!");
            resp.put("account", username);
            resp.put("token", token);
        } else {
            resp.put("code", 500);
            resp.put("msg", "password fault!");
        }
        return resp;
    }

    @Override
    public JSONObject repoRegister(Repository repository) {
        JSONObject resp = new JSONObject();
        String account = repository.getRep_account();
        Staff result = repositoryMapper.selectByAccount(account);
        if (result != null) {
            resp.put("code", 500);
            resp.put("msg", "the account is already exist");
            return resp;
        }
        if (repository.getRep_name() == null) {
            repository.setRep_name(account);
        }
        try {
            repositoryMapper.insert(repository.getRep_name(), repository.getRep_account(),
                    repository.getRep_password(), repository.getRep_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "insert error");
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "Register successful!");
        return resp;
    }

    @Override
    public JSONObject salesmanChangePwd(String account, String newPwd, String oldPwd) {
        JSONObject resp = new JSONObject();
        Staff salesman = salesmanMapper.selectByAccount(account);
        if (salesman == null) {
            resp.put("code", 500);
            resp.put("msg", "the salesman not exist");
            return resp;
        }
        if (salesman.getS_password().equals(oldPwd)) {
            try {
                salesmanMapper.changePwd(salesman.getS_id(), newPwd);
            } catch (Exception e) {
                resp.put("code", 500);
                resp.put("msg", "change error");
                resp.put("error", e.toString());
                return resp;
            }
            resp.put("code", 200);
            resp.put("msg", "change successful");
        } else {
            resp.put("code", 500);
            resp.put("msg", "the old password error");
        }
        return resp;
    }

    @Override
    public JSONObject repoChangePwd(String account, String newPwd, String oldPwd) {
        JSONObject resp = new JSONObject();
        Staff repository = repositoryMapper.selectByAccount(account);
        if (repository == null) {
            resp.put("code", 500);
            resp.put("msg", "the repository not exist");
            return resp;
        }
        if (repository.getS_password().equals(oldPwd)) {
            try {
                repositoryMapper.changePwd(repository.getS_id(), newPwd);
            } catch (Exception e) {
                resp.put("code", 500);
                resp.put("msg", "change error");
                return resp;
            }
            resp.put("code", 200);
            resp.put("msg", "change successful");
        } else {
            resp.put("code", 500);
            resp.put("msg", "the old password error");
        }
        return resp;
    }

    @Override
    public JSONObject managerLogin(String username, String password) {
        Staff manager = managerMapper.selectManagerByAccount(username);
        JSONObject resp = new JSONObject();
        if (manager == null) {
            resp.put("code", 500);
            resp.put("msg", "user not exists!");
            return resp;
        }
        if (manager.getS_password().equals(password)) {
            String token = TokenUtils.createToken(username);
            resp.put("code", 200);
            resp.put("msg", "login successful!");
            resp.put("account", username);
            resp.put("token", token);
        } else {
            resp.put("code", 500);
            resp.put("msg", "password fault!");
        }
        return resp;
    }

    @Override
    public JSONObject managerRegister(Staff staff) {
        JSONObject resp = new JSONObject();
        String account = staff.getS_account();
        Staff result = managerMapper.selectManagerByAccount(account);
        if (result != null) {
            resp.put("code", 500);
            resp.put("msg", "the account is already exist");
            return resp;
        }
        if (staff.getS_name() == null) {
            staff.setS_name(account);
        }
        try {
            managerMapper.insert(staff.getS_name(), staff.getS_account(),
                    staff.getS_password(), staff.getS_phone());
        } catch (Exception e) {
            resp.put("code", 500);
            resp.put("msg", "insert error");
            return resp;
        }
        resp.put("code", 200);
        resp.put("msg", "Register successful!");
        return resp;
    }

    @Override
    public JSONObject managerChangePwd(String account, String newPwd, String oldPwd) {
        JSONObject resp = new JSONObject();
        Staff manager = managerMapper.selectManagerByAccount(account);
        if (manager == null) {
            resp.put("code", 500);
            resp.put("msg", "the manager not exist");
            return resp;
        }
        if (manager.getS_password().equals(oldPwd)) {
            try {
                managerMapper.changePwd(manager.getS_id(), newPwd);
            } catch (Exception e) {
                resp.put("code", 500);
                resp.put("msg", "change error");
                return resp;
            }
            resp.put("code", 200);
            resp.put("msg", "change successful");
        } else {
            resp.put("code", 500);
            resp.put("msg", "the old password error");
        }
        return resp;
    }

    @Override
    public JSONObject cusChangePwd(String account, String newPwd, String oldPwd) {
        JSONObject resp = new JSONObject();
        Customer customer = custMapper.selectByAccount(account);
        if (customer == null) {
            resp.put("code", 500);
            resp.put("msg", "the manager not exist");
            return resp;
        }
        if (customer.getCus_password().equals(oldPwd)) {
            try {
                custMapper.changePwd(customer.getCus_id(), newPwd);
            } catch (Exception e) {
                resp.put("code", 500);
                resp.put("msg", "change error");
                return resp;
            }
            resp.put("code", 200);
            resp.put("msg", "change successful");
        } else {
            resp.put("code", 500);
            resp.put("msg", "the old password error");
        }
        return resp;
    }
}
