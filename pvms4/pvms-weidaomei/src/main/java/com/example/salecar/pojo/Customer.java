package com.example.salecar.pojo;

import lombok.Data;

@Data
public class Customer {
    private int cus_id;
    private String cus_name;
    private String cus_account;
    private String cus_password;
    private String cus_phone;
}
