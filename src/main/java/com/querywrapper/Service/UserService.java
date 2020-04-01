package com.querywrapper.Service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.toolkit.Constants;
import com.baomidou.mybatisplus.extension.service.IService;
import com.querywrapper.domain.User;
import org.apache.ibatis.annotations.Param;


public interface UserService extends IService<User> {

    int deleteByName(@Param(Constants.WRAPPER) Wrapper<User> userWrapper);

}
