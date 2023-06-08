package com.example.salecar.dao;

import com.example.salecar.pojo.Good;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GoodMapper {//w物品的增删查改

    @Select("select * from good where goodss_id=#{id}")
    Good selectByPrimaryKey(int id);


    @Insert("insert into good (goodss_id,goods_type,goods_brand,sup_id,goods_color,goods_comment,goods_engine,goods_trans)" +
            "values(0,#{good_type},#{good_brand},#{sup_id},#{good_color},#{good_comment},#{good_engine},#{good_trans})")
    int insert(String good_type, String good_brand, Integer sup_id, String good_color,String good_comment,String good_engine,String good_trans);

    @Delete("delete from good where goodss_id = #{id}")
    int deleteByPrimaryKey(Integer id);

    @Update("update good set goods_type=#{good_type},goods_brand=#{good_brand},sup_id=#{sup_id},goods_color=#{good_color},goods_comment=#{good_comment},goods_engine=#{good_engine},goods_trans=#{good_trans} " +
            "where goodss_id=#{good_id}")
    int updateByPrimaryKey(Integer good_id, String good_type, String good_brand, Integer sup_id, String good_color,String good_comment,String good_engine,String good_trans);

    @Select({"<script>",
            "select * from pvms.good",
            "where 1=1 ",
            " <if test='searchcarid!= null and searchcarid !=\"\" '>",
            " and goodss_id = #{searchcarid}",
            " </if>",
            " <if test='searchsid!= null and searchsid !=\"\" '>",
            " and sup_id =#{searchsid}",
            " </if>" ,
            "</script>"})
    List<Good> showgoods(String searchcarid, String searchsid);
}
