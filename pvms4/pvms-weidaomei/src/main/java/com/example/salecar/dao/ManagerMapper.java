package com.example.salecar.dao;

import com.example.salecar.pojo.Staff;
import org.apache.ibatis.annotations.*;

@Mapper
public interface ManagerMapper {
    @Select("select * from Staff where s_department=4 and s_id=#{id};")
    Staff selectManagerById(int id);

    @Insert("insert into staff values (0,#{name},#{account},#{password},#{phone},4);")
    void insert(String name, String account, String password, String phone);

    @Delete("delete from Staff where s_department=4 and s_id=#{id};")
    void deleteById(int id);

    @Update("update Staff " +
            "set s_name=#{name},s_account=#{account},s_password=#{password},s_phone=#{phone} " +
            "where s_department=4 and s_id=#{id};")
    void updateById(int id, String name, String account, String password, String phone);

    @Select("select * from Staff where s_department=4 and s_account=#{account};")
    Staff selectManagerByAccount(String account);

    @Update("update Staff set s_password=#{newPwd} " +
            "where s_department=4 and s_id=#{id};")
    void changePwd(int s_id, String newPwd);
}
