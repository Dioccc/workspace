package com.dx.test;

import com.dx.dao.CoustomerDao;
import com.dx.po.Customer;
import com.dx.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMyBatis {
    @Test
    public void   testById(){
        SqlSession sqlSession= MybatisUtils.getSession(false);
        Customer customer=sqlSession.selectOne("findCustomerById",2);
        System.out.println(customer);
        MybatisUtils.closeSqlSession(sqlSession);
    }
    @Test
    public void testAdd(){
        SqlSession sqlSession= MybatisUtils.getSession(true);
        Customer customer=new Customer();
        customer.setUsername("jerry");
        customer.setJobs("司机");
        customer.setPhone("15485788188");
        int rows=sqlSession.insert("addCustomer",customer);
        System.out.println("成功添加"+rows+"条数据");
        MybatisUtils.closeSqlSession(sqlSession);
    }
    @Test
    public void testDelete(){
        SqlSession sqlSession=MybatisUtils.getSession(true);
        int rows=sqlSession.delete("deleteCustomer",5);
        System.out.println("成功删除"+rows+"条数据");
        MybatisUtils.closeSqlSession(sqlSession);
    }
    @Test
    public void testUpdate(){
        SqlSession sqlSession=MybatisUtils.getSession(true);
        Customer customer=new Customer();
        customer.setId(4);
        customer.setUsername("jerry");
        customer.setPhone("1567163544");
        customer.setJobs("司机");
        int rows=sqlSession.update("updateCustomer",customer);
        System.out.println("成功修改"+rows+"条数据");
    }
    @Test
    public void testFindAny(){
        SqlSession sqlSession=MybatisUtils.getSession(false);
        String columnName="username";
        String keyword="o";
        int curPage=1;
        int pageSize=2;
        int start=(curPage-1)*pageSize;
        Map<String,Object> map=new HashMap<>();
        map.put("columnName",columnName);
        map.put("keyword",keyword);
        map.put("start",start);
        map.put("pageSize",pageSize);
        List<Customer> customers=sqlSession.selectList("findAny",map);
        for (Customer customer:customers
             ) {
            System.out.println(customer);
        }


    }
}
