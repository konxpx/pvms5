package com.example.salecar.dao;

import com.example.salecar.pojo.Chart;
import com.example.salecar.pojo.Chart_Pie;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface charts_pieMapper {
    @Select("SELECT \n" +

            "count(*)'value',\n" +
            "pur_state 'name'\n" +
            "FROM purorder\n" +
            "GROUP BY pur_state\n")
    List<Chart_Pie> quanofstate();
    @Select("SELECT\n" +

            "COUNT(*) 'value',\n" +
            "book_addr 'name'\n" +
            "FROM book\n" +
            "GROUP BY book_addr\n" +
            "\n")
    List<Chart_Pie>quanofbook();
}
