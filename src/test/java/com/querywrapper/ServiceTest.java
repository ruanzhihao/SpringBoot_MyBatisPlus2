package com.querywrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.querywrapper.Service.UserService;
import com.querywrapper.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ServiceTest {
    @Autowired
    private UserService userService;
    @Test
    public void selectAllUser(){
int i=userService.deleteByName(new QueryWrapper<User>().eq("username","A"));
        System.out.println(i);
    }

}
