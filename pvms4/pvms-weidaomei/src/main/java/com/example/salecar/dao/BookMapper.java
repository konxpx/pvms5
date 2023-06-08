package com.example.salecar.dao;

import com.example.salecar.pojo.Book;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface BookMapper {
    @Insert("insert into book(cus_id,car_id,s_id,book_time,book_addr)" +
            "values(#{cusid},#{carid},#{sid},#{time},#{addr})")
    int insert(int cusid, int carid, int sid,String time, String addr);

    @Delete("delete from book where book_id=#{id}")
    int deleteByPrimaryKey(int id);

    @Select("select * from book where book_id = #{id}")
    Book selectByPrimaryKey(int id);

    @Update("update book set cus_id=#{cusid},car_id=#{carid},s_id=#{sid},book_time=#{time},book_addr=#{addr}" +
            " where book_id=#{bookid}")
    int updateByPrimaryKey(int bookid,int cusid,int carid,int sid, String time, String addr);

//    @Select("select * from book where book_id like #{account}")
//    Book selectById(String account);

    @Select({"<script>",
            "select * from book",
            "where 1=1",
            " <if test='searchCusid!= null and searchCusid !=\"\" '>",
            " and cus_id = #{searchCusid}",
            " </if>",
            " <if test='searchStaffid!= null and searchStaffid !=\"\" '>",
            " and car_id =#{searchStaffid}",
            " </if>" ,
            "</script>"})
    List<Book> getBookList(String searchCusid, String searchStaffid);

}
