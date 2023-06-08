package com.example.salecar.dao;

import com.example.salecar.pojo.Customer;
import com.example.salecar.pojo.Stock;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface StockMapper {
    @Insert("insert into stock (stock_id,car_id,stock_intime,stock_outtime)" +
            "values (0,#{car_id},#{stock_intime},#{stock_outtime})")
    int insert(Integer car_id, String stock_intime, String stock_outtime);

    @Delete("delete from stock where stock_id = #{id}")
    void deleteByPrimaryKey(Integer id);

    @Select("select * from stock where car_id=#{id}")
    Stock selectByPrimaryKey(int id);

    @Update("update stock set car_id=#{car_id},stock_intime=#{stock_intime},stock_outtime=#{stock_outtime}" +
            "where stock_id=#{stock_id}")
    void updateByPrimaryKey(Integer stock_id, Integer car_id, String stock_intime, String stock_outtime);
    @Select("select * from stock,car where car.car_type=#{type} and stock.car_id=car.car_id")
    List<Stock> getCarByType(String type);

//    @Select("select * from stock")
//    List<Stock> getCarList();
@Select({"<script>",
        "select * from stock",
        "where 1=1",
        " <if test='searchKid!= null and searchKid !=\"\" '>",
        " and stock_id= #{searchKid}",
        " </if>",
        " <if test='searchCid!= null and searchCid !=\"\" '>",
        " and car_id =#{searchCid}",
        " </if>" ,
        "</script>"})
List<Stock> showStock(String searchKid, String searchCid);

}
