package com.example.salecar.dao;

import com.example.salecar.pojo.Customer;
import com.example.salecar.pojo.Staff;
import com.example.salecar.pojo.Supplier;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface SupplierMapper {
    @Insert("insert into pvms.supplier(sup_id, sup_name, sup_address, sup_phone, sup_person)" +
            "values(0,#{name},#{address},#{phone},#{person})")
    int insert(String name, String address, String phone, String person);

    @Delete("delete from pvms.supplier where sup_id=#{id}")
    int deleteByPrimaryKey(int id);

    @Select("select * from pvms.supplier where sup_id = #{id}")
    Supplier selectByPrimaryKey(int id);

    @Update("update pvms.supplier set sup_name=#{name},sup_address=#{address},sup_phone=#{phone}," +
            "sup_person=#{person} where sup_id=#{id}")
    int updateByPrimaryKey(Integer id, String name, String address, String phone, String person);

    @Select("select * from pvms.supplier where sup_name like #{name}")
    List<Supplier> selectByName(String name);

//    @Select("select * from pvms.supplier")
//    List<Supplier> getSupplierList();
@Select({"<script>",
        "select * from supplier",
        "where 1=1",
        " <if test='searchName!= null and searchName !=\"\" '>",
        " and sup_name = #{searchName}",
        " </if>",
        " <if test='searchId!= null and searchId !=\"\" '>",
        " and sup_id =#{searchId}",
        " </if>" ,
        "</script>"})
List<Supplier> getSupplierList(String searchName, String searchId);

}
