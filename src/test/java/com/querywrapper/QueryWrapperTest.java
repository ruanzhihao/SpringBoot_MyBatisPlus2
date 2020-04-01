package com.querywrapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mysql.cj.QueryResult;
import com.querywrapper.Service.UserService;
import com.querywrapper.dao.UserMapper;
import com.querywrapper.domain.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class QueryWrapperTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;
    @Test
    public void selectAllUser(){
        User user= userService.getById(1);
        System.out.println(user);
    }
    /*QueryWrapper queryWrapper=new QueryWrapper();*/
    @Test
    public void testCustom(){
/*       List<User> users= userMapper.findAllUser();
        users.forEach(System.out::println);*/

  /*    Integer id=3;
     int i= userMapper.deleteById(id);*/
/*  QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
  queryWrapper.eq("username","王二小");
  int i=userMapper.deleteByName(queryWrapper);
      if (i==1){
          System.out.println("删除成功");
      }*/
        QueryWrapper<User> queryWrapper1=new QueryWrapper<User>();
      queryWrapper1.eq("id",5);
      int i1=userMapper.updateNmae(queryWrapper1,"抠鼻王");

    }
    @Test
    public void SelectPages(){
        //第一步给Spring配置注入PaginationInterceptor对象
        //第二步创建Page对象该对象的第一个参数表示当前页，第二个参数表示每页有多少条记录,第三个参数默认为true,为true则会先查询总数
        //设置为false则不会查询总数,亦不会查询总页数
        /**
         * limit start pageSize;
         *
         * start:就是当前页的起始索引,pageSize就是每页的条数
         *
         * currentPage:就是当前页
         *
         * 公式:start=(currentPage-1)*pageSize
         */
        Page<User> page=new Page<User>(1,3,true);
        //查询结果的返回值是IPage类型
/*
        IPage<User> iPage=userMapper.selectPage(page,null);
*/

        System.out.println("------------自定义sql分页------------");
        QueryWrapper<User> queryWrapper=new QueryWrapper<User>();
        queryWrapper.ge("score",40);
        IPage<User> iPage=userMapper.selectMyPage(page,queryWrapper);
        System.out.println("记录总数："+iPage.getTotal());
        System.out.println("当前页："+iPage.getCurrent());
        System.out.println("共有"+iPage.getPages()+"页");
        List<User> list=iPage.getRecords();
        list.forEach(System.out::println);
    }
    @Test
    public void insertTest(){
      User user1=new User(8,"B","123","1213232","ANHUISHENG","34");
      userMapper.insert(user1);

    }
    @Test
    public void testQueryWrapper(){
     /*   System.out.println("----------查询所有-----------");
        List<User> users=userMapper.selectList(null);
        users.forEach(System.out::println);*/
        System.out.println("----------QueryWrapper条件构造器，构造条件查询----------");
        QueryWrapper<User> queryWrapper=new QueryWrapper();

        //eq("username","zhangsan8");根据名字selectOne
        /*queryWrapper.eq("username","zhangsan8");
        User user=userMapper.selectOne(queryWrapper);
        System.out.println(user);*/

        //ne --->notequal---->'<>'
     /*   queryWrapper.ne("username","zhangsan1");
        List<User> users1=userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);*/

     //gt--->graterThan---'>';ge----->'>=';lt----->'<';le------>'<='
 /*       queryWrapper.le("score",80);
        List<User> users1=userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);*/

        //between 两者之间queryWrapper.between("score",31,49);包含前后参数所指对象 ----->
        //notBetween 不在两者之间，不包括参数值所指向对象
         /*queryWrapper.notBetween("score",30,50);
         List<User> users1=userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);*/

         //like--->'like %值%'notLike---->'not like %值%'
        //likeLeft------'like %值'
        //likeRight-----'like 值%'
      /*  queryWrapper.likeRight("username",'王');
        List<User> users1=userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);*/

        //isNull 表示条件为空,查询为空的值
        //******使用多条件查询时必须给QueryWrapper加上<T>,否则不可使用***
        /*queryWrapper.isNotNull("username");
        List<User> users1=userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);*/

        //in --->score in
        /*queryWrapper.notIn("score",30,80);*/
/*
        queryWrapper.in("username","抠鼻王","王二小");
        List<User> users1=userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);
*/

        // score in (select score from user where score>=30)
        //notSql------->NOT IN...
        queryWrapper.inSql("score","select score from user where score>=30");
        List<User> users1=userMapper.selectList(queryWrapper);
        users1.forEach(System.out::println);

        //
    }
 }
