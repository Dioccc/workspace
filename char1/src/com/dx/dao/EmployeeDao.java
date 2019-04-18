package com.dx.dao;

import com.dx.po.Employee;
import com.dx.po.Link;

import java.util.List;

public interface EmployeeDao {
    //增
    public int addEmployee(Employee employee);
    //改
    public int updateEmployee(Employee employee);
    //删
    public int deleteEmployee(String eid);
    //查询单个
    public Employee findEmployee(String eid);
    //查询全部
    public List<Employee> findAll();
    //转账
    boolean transfer(String outUser,String inUser,Double money);
    //模糊查询
    public List<Employee> moFindByName();
    //分页
    public List<Employee> findLimit();
    //模糊加分页
    public List<Employee> moFindLimit();
    //批量添加
    public boolean batchInserEmp(List<Employee> employeeList);
    //批量修改
    public boolean batchUpdateEmp(String sql,List<String> eids);
    //批量删除
    public boolean batchDeleteEmp(List<String> eids);
    //联合查询
    public List<Link> linkFind(Employee employee);

}
