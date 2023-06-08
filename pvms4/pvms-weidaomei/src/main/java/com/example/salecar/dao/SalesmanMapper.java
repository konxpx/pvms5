package com.example.salecar.dao;

import com.example.salecar.pojo.Customer;
import com.example.salecar.pojo.Salesman;
import com.example.salecar.pojo.Staff;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SalesmanMapper {
    @Insert("insert into staff (s_id,s_name,s_account,s_password,s_phone,s_department) " +
            "values(0,#{sale_name},#{sale_account},#{sale_password},#{sale_phone},1)")
    int insert(String sale_name, String sale_account, String sale_password, String sale_phone);

    @Delete("delete from staff where s_id=#{id}")
    int deleteByPrimaryKey(int id);

    @Select("select * from staff where s_id=#{id}")
    Staff selectByPrimaryKey(int id);

    @Select("select * from staff where s_account=#{account} and s_department=1")
    Staff selectByAccount(String account);

    @Update("update staff set s_name=#{sale_name},s_account=#{sale_account}," +
            "s_password=#{sale_password},s_phone=#{sale_phone} " +
            "where s_id=#{sale_id}")
    int updateByPrimaryKey(Integer sale_id, String sale_name, String sale_account,
                           String sale_password, String sale_phone);

//    @Select("select * from staff where s_department=1")
//    List<Staff> getSalesmanList();
@Select({"<script>",
        "select * from staff",
        "where 1=1 ",
        "and s_department=1",
        " <if test='searchName!= null and searchName !=\"\" '>",
        " and s_name = #{searchName}",
        " </if>",
        " <if test='searchId!= null and searchId !=\"\" '>",
        " and s_id =#{searchId}",
        " </if>" ,
        "</script>"})
List<Staff> getSalesmanList(String searchName, String searchId);

    @Update("update staff set s_password=#{newPwd} where s_id=#{ID}")
    void changePwd(Integer ID, String newPwd);
}
