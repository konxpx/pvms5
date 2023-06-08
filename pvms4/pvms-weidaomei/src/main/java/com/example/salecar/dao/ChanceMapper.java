package com.example.salecar.dao;

import com.example.salecar.pojo.Chance;
import com.example.salecar.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ChanceMapper {
    @Insert("insert into chance (ch_id,cus_id,ch_num,ch_comment) " +
            "values(0,#{cus_id},#{ch_num},#{ch_comment})")
    void insert(Integer cus_id, Integer ch_num, String ch_comment);

    @Delete("delete from chance where ch_id=#{ch_id}")
    void delete(Integer ch_id);

    @Update("update chance set cus_id=#{cus_id},ch_num=#{ch_num},ch_comment=#{ch_comment} " +
            "where ch_id=#{ch_id}")
    void update(Integer ch_id, Integer cus_id, Integer ch_num, String ch_comment);

    @Select("select * from chance where ch_id=#{ch_id}")
    Chance selectChanceById(Integer ch_id);

    @Select({"<script>",
            "select * from chance",
            "where 1=1 ",
            " <if test='searchchid!= null and searchchid !=\"\" '>",
            " and ch_id = #{searchchid}",
            " </if>",
            " <if test='searchId!= null and searchId !=\"\" '>",
            " and cus_id =#{searchId}",
            " </if>" ,
            "</script>"})
    List<Chance> showChances(String searchchid, String searchId);
//    @Select("select * from chance")
//    List<Chance> showChances();
}
