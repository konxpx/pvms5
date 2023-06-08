package com.example.salecar.pojo;

import lombok.Data;

@Data
public class Order {
    private int o_id;
    private int car_id;
    private int cus_id;
    private String o_status;
    private String o_ctime;
    private String o_ftime;
    private int o_price;
}
