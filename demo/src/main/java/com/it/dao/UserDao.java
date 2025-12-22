package com.it.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.it.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserDao {
    @Select("select * from users limit 1")
    public User show();
    //注册
    @Insert("insert into users(username,password,role,status) values(#{username},#{password},#{role},#{status})")
    public int register(User user);
    //登录验证
    @Select("select * from users where username=#{username} and password=#{password} and role=#{role}")
    public User login(@Param("username") String username, @Param("password") String password, @Param("role") String role);
}
