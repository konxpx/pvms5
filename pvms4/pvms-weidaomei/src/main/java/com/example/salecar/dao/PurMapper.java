package com.example.salecar.dao;

import com.example.salecar.pojo.Purorder;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface PurMapper {
    @Insert("insert into purorder (pur_id,car_id,pur_price1,pur_disc,pur_price2," +
            "pur_ctime,pur_ftime,pur_state) " +
            "values(0,#{car_id},#{pur_price1},#{pur_disc},#{pur_price2}," +
            "#{pur_ctime},#{pur_ftime},#{pur_state})")
    void insert(Integer car_id, Integer pur_price1, Double pur_disc, Double pur_price2,
                String pur_ctime, String pur_ftime, String pur_state);

    @Delete("delete from purorder where pur_id=#{pur_id}")
    void delete(Integer pur_id);

    @Update("update purorder set car_id=#{car_id},pur_price1=#{pur_price1},pur_disc=#{pur_disc},pur_price2=#{pur_price2},pur_ctime=#{pur_ctime},pur_ftime=#{pur_ftime},pur_state=#{pur_state} " +
            "where pur_id=#{pur_id}")
    void update(Integer pur_id, Integer car_id, Integer pur_price1, Double pur_disc, Double pur_price2,
                String pur_ctime, String pur_ftime, String pur_state);

    @Select("select * from purorder where pur_id=#{pur_id}")
    Purorder selectPurorderById(Integer pur_id);

//    @Select("select * from purorder")
//    List<Purorder> showChances();
@Select({"<script>",
        "select * from pvms.purorder",
        "where 1=1 ",
        " <if test='searchPid!= null and searchPid !=\"\" '>",
        " and pur_id = #{searchPid}",
        " </if>",
        " <if test='searchCid!= null and searchCid !=\"\" '>",
        " and car_id =#{searchCid}",
        " </if>" ,
        "</script>"})
List<Purorder> showChances(String searchPid, String searchCid);
}
