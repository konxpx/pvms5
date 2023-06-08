package com.example.salecar.pojo;
import lombok.Data;
@Data
public class Purorder {
    private int pur_id;
    private int car_id;
    private int pur_price1;
    private double pur_disc;
    private double pur_price2;
    private String pur_ctime;
    private String pur_ftime;
    private String pur_state;
}
