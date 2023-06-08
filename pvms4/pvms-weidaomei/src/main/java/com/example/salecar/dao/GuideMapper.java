package com.example.salecar.dao;

import com.example.salecar.pojo.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GuideMapper {
    @Insert("insert into staff (s_id,s_name,s_account,s_password,s_phone,s_department)" +
            "values(0,#{rep_name},#{rep_account},#{rep_password},#{rep_phone},3)")
    int insert(String rep_name, String rep_account, String rep_password, String rep_phone);

    @Delete("delete from staff where s_id=#{id}")
    int deleteByPrimaryKey(int id);

    @Select("select * from staff where s_id=#{id}")
    Staff selectByPrimaryKey(int id);

    @Update("update staff set s_id=#{rep_id},s_name=#{rep_name},s_account=#{rep_account}," +
            "s_password=#{rep_password},s_phone=#{rep_phone} " +
            "where s_id=#{rep_id}")
    int updateByPrimaryKey(Integer rep_id, String rep_name, String rep_account, String rep_password, String rep_phone);


    @Select({"<script>",
            "select * from staff",
            "where 1=1",
            "and s_department=3",
            " <if test='searchName!= null and searchName !=\"\" '>",
            " and s_name = #{searchName}",
            " </if>",
            " <if test='searchId!= null and searchId !=\"\" '>",
            " and s_id =#{searchId}",
            " </if>" ,
            "</script>"})
    List<Staff> getGuideList(String searchName, String searchId);

    @Select("select * from staff where s_account=#{account} and s_department=3")
    Staff selectByAccount(String account);
}
