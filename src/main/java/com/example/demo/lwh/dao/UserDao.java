package com.example.demo.lwh.dao;

import com.example.demo.lwh.po.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserDao{
    @Select(value = "select * from user where id=#{id}")
    User getUserByid(@Param("id") Long id);

    @Select(value = "select * from user where username=#{username}")
    User getUserByname(@Param("name") String username);

    @Select(value = "select * from user where username=#{username} and password=#{password}")
    User getbyUsernameAndPassword(@Param("username") String username, @Param("password") String password);

    @Select(value = "select count(*) from user where username=#{username}")
    @Results(
            value = {@Result(column = "username",property = "username")
            }
    )
    Long isexist(@Param("username") String username);

    @Insert("insert into user(username,password) values(#{name},#{password})")
    @Options(useGeneratedKeys = true,keyColumn = "id",keyProperty = "id") //告诉mybatis哪个是自增长的主键
    int saveUser(@Param("username") String username,@Param("password") String password);

    @Select(value = "select * from user")
    @Results(
            id = "user",
            value = {@Result(column = "username",property = "username"),
                    @Result(column = "id",property = "id")
            }
    )
    List<User> getAllUser();
}
