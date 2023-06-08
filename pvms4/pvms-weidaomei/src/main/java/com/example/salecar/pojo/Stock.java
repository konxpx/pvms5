package com.example.salecar.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")

@Data
public class Stock {
    private int stock_id;
    private int car_id;
    private String stock_intime;
    private String stock_outtime;
}
