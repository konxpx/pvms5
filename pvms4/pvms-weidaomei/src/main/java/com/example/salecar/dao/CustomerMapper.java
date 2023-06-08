package com.example.salecar.dao;

import com.example.salecar.pojo.Customer;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface CustomerMapper {
    @Insert("insert into customer(cus_id, cus_name, cus_account, cus_password, cus_phone)" +
            "values(0,#{name},#{account},#{password},#{phone})")
    int insert(String name, String account, String password, String phone);

    @Delete("delete from customer where cus_id=#{id}")
    int deleteByPrimaryKey(int id);

    @Select("select * from customer where cus_id = #{id}")
    Customer selectByPrimaryKey(int id);

    @Update("update customer set cus_name=#{name},cus_account=#{account},cus_password=#{password}," +
            "cus_phone=#{phone} where cus_id=#{id}")
    int updateByPrimaryKey(Integer id, String name, String account, String password, String phone);

    @Select("select * from customer where cus_account like #{account}")
    Customer selectByAccount(String account);

    @Select("select * from customer where cus_phone=#{phone}")
    Customer selectByPhone(String phone);

    @Select({"<script>",
            "select * from customer",
            "where 1=1",
            " <if test='searchName!= null and searchName !=\"\" '>",
            " and cus_name = #{searchName}",
            " </if>",
            " <if test='searchId!= null and searchId !=\"\" '>",
            " and cus_id =#{searchId}",
            " </if>",
            "</script>"})
    List<Customer> getCustomerList(String searchName, String searchId);

    @Update("update customer set cus_password=#{newPwd} " +
            "where cus_id=#{cus_id};")
    void changePwd(int cus_id, String newPwd);
}
