package com.querywrapper.Service.Impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.querywrapper.Service.UserService;
import com.querywrapper.dao.UserMapper;
import com.querywrapper.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public int deleteByName(Wrapper<User> userWrapper) {
        return userMapper.deleteByName(userWrapper);
    }
}
