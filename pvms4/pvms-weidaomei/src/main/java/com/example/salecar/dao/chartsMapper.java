package com.example.salecar.dao;

import com.example.salecar.pojo.Chart;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface chartsMapper {
    @Select("SELECT\n" +
            "\tcar_brand 'name',\n" +
            "\tCOUNT(*) 'number' \n" +
            "FROM\n" +
            "\tcar,\n" +
            "\tstock \n" +
            "WHERE car.car_id=stock.car_id\n" +
            "GROUP BY\n" +
            "\tcar_brand;")
    List<Chart> quanofbrand();

    //TODO:查订单图表

    //TODO：查...图表

    @Select("SELECT\n" +
            "s_department 'name',\n" +
            "COUNT(*) 'number'\n" +
            "FROM staff\n" +
            "GROUP BY s_department\n")
    List<Chart> quanofstaff();
    @Select("SELECT \n" +
            "Car.car_brand 'name',\n" +
            "SUM(`order`.o_price) 'number'\n" +
            "FROM car,`order`\n" +
            "WHERE car.car_id=`order`.car_id\n" +
            "GROUP BY car.car_brand")
    List<Chart> quanofordercar();
    @Select("SELECT *\n" +
            "FROM(\n" +
            "SELECT\n" +
            "cus_name 'name',\n" +
            "SUM(o_price) 'number'\n" +
            "FROM customer,`order`\n" +
            "WHERE customer.cus_id=`order`.cus_id\n" +
            "GROUP BY cus_name\n" +
            "ORDER BY number DESC) AS a\n" +
            "WHERE 1=1 LIMIT 3;\n")
    List<Chart> quanofmoney();

}
