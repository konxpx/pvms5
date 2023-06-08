package com.example.salecar.pojo;

import lombok.Data;

@Data
public class Goodprice {
    private int cp_id;
    private int car_id;
    private int cp_price1;
    private double cp_disc;
    private String cp_disctype;
    private double cp_price2;
}
