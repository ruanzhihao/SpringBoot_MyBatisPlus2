package com.querywrapper.dao;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.querywrapper.domain.User;

import com.baomidou.mybatisplus.core.toolkit.Constants;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;


import java.util.List;

@Component
public interface UserMapper extends BaseMapper<User> {
    //和MyBatis 一致的自定义sql语句
    @Select("select * from user")
    List<User> findAllUser();
    @Delete("delete from user where id=#{uid}")
    int deleteById(@Param("uid") Integer id);

    //使用自定义sql语句,同时又想使用条件构造器
    @Delete("delete from user ${ew.customSqlSegment}")
    int deleteByName(@Param(Constants.WRAPPER) Wrapper<User> userWrapper);

    @Update("update user set username=#{username} ${ew.customSqlSegment}")
    int updateNmae(@Param(Constants.WRAPPER) Wrapper<User> userWrapper,@Param("username") String username);

    @Select("select * from user ${ew.customSqlSegment}")
    IPage<User> selectMyPage(IPage<User> page,@Param(Constants.WRAPPER) Wrapper<User> userWrapper);
}
