package com.example.salecar.dao;

import com.example.salecar.pojo.Goodprice;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodPriceMapper {
    @Insert("insert into carprice (cp_id,car_id,cp_price1,cp_disc,cp_disctype,cp_price2) " +
            "values(0,#{car_id},#{cp_price1},#{cp_disc},#{cp_disctype},#{cp_price2})")
    void insert(Integer car_id, Integer cp_price1, Double cp_disc, String cp_disctype, Double cp_price2);

    @Delete("delete from carprice where cp_id=#{cp_id}")
    void delete(Integer cp_id);

    @Update("update carprice set car_id=#{car_id},cp_price1=#{cp_price1},cp_disc=#{cp_disc},cp_disctype=#{cp_disctype},cp_price2=#{cp_price2} " +
            "where cp_id=#{cp_id}")
    void update(Integer cp_id, Integer car_id, Integer cp_price1, Double cp_disc, String cp_disctype, Double cp_price2);

    @Select("select * from carprice where cp_id=#{cp_id}")
    Goodprice selectPriceById(Integer cp_id);

    @Select({"<script>",
            "select * from carprice",
            "where 1=1",
            " <if test='searchpid!= null and searchpid !=\"\" '>",
            " and cp_id = #{searchpid}",
            " </if>",
            " <if test='searchcid!= null and searchcid !=\"\" '>",
            " and car_id =#{searchcid}",
            " </if>" ,
            "</script>"})
    List<Goodprice> getPriceList(String searchpid, String searchcid);

}
