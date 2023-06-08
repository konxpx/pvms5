package com.example.salecar.dao;

import com.example.salecar.pojo.Order;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface OrderMapper {
    @Insert("insert into pvms.order (o_id,car_id,cus_id,o_status,o_ctime,o_ftime,o_price) values " +
            "(0,#{car_id},#{cus_id},#{o_status},#{o_ctime},#{o_ftime},#{o_price})")
    int insert(Integer car_id, Integer cus_id, String o_status, String o_ctime, String o_ftime, Integer o_price);

    @Delete("delete from pvms.order where o_id=#{id}")
    int deleteByPrimaryKey(int id);

    @Select("select * from pvms.order where o_id=#{id}")
    Order selectByPrimaryKey(int id);

    @Select("select * from pvms.order,pvms.customer where customer.cus_name=#{cus_name} and order.cus_id=customer.cus_id")
    List<Order> selectByCustomer(String cus_name);

    /*@Select("select * from pvms.order where order_date=#{date}")
    List<Order> selectByDate(String date);*/

    @Update("update pvms.order set car_id=#{car_id},cus_id=#{cus_id}," +
            "o_status=#{o_status},o_ctime=#{o_ctime},o_ftime=#{o_ftime},o_price=#{o_price} " +
            "where o_id=#{o_id}")
    int updateByPrimaryKey(Integer o_id, Integer car_id, Integer cus_id,
                           String o_status, String o_ctime, String o_ftime, Integer o_price);


    @Select({"<script>",
            "select * from pvms.order",
            "where 1=1 ",
            " <if test='searchoid!= null and searchoid !=\"\" '>",
            " and o_id = #{searchoid}",
            " </if>",
            " <if test='searchcusId!= null and searchcusId !=\"\" '>",
            " and cus_id =#{searchcusId}",
            " </if>" ,
            "</script>"})
    List<Order> showOrders(String searchoid, String searchcusId);
//    @Select("select * from pvms.order")
//    List<Order> showOrders();
}
