package com.dx.test;

import com.dx.dao.EmployeeDao;
import com.dx.po.Company;
import com.dx.po.Department;
import com.dx.po.Employee;
import com.dx.po.Link;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.ArrayList;
import java.util.List;

public class TestUI {
    ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextWithAnnotation.xml");
    EmployeeDao employeeDao = ac.getBean("employeeDao", EmployeeDao.class);
    @Test
    public void test1(){
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContext.xml");
        Employee employee = ac.getBean("employee", Employee.class);
        Company company = ac.getBean("company", Company.class);
        Department department = ac.getBean("department", Department.class);
        System.out.println(employee);
        System.out.println(company);
        System.out.println(department);
    }
    @Test
    //增加雇员
    public void testAdd() {

        Employee employee=new Employee("2","giao3","男",18,20000);
        int num=employeeDao.addEmployee(employee);
        System.out.println("成功增加"+num+"条数据");
    }

    @Test
    //修改
    public void testUpdate() {
        Employee employee=new Employee("2","giao3","男",18,20000);
        int num =employeeDao.updateEmployee(employee);
        System.out.println("成功更改第"+employee.getEid()+"行的数据");
    }
    @Test
    //删除
    public void testDelete() {
        Employee employee=new Employee();
        int num=employeeDao.deleteEmployee("123547");
        System.out.println("成功更改"+num+"条的数据");
    }
    @Test
    //查询单个
    public void testFindById() {
        ApplicationContext ac=new ClassPathXmlApplicationContext("applicationContextWithAnnotation.xml");
        EmployeeDao employeeDao = ac.getBean("employeeDao", EmployeeDao.class);
        Employee e=employeeDao.findEmployee("3");
        System.out.println(e);

    }
    @Test
    //查询全部
    public void test2FindAll(){
        List<Employee> employees=employeeDao.findAll();
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
    @Test
    //红包转账
    public void test2TansFer(){
        boolean isOK=employeeDao.transfer("2","3",5000d);
        if(isOK){
            System.out.println("转账成功");
        }
        else {
            System.out.println("转账失败");
        }

    }
    @Test
    //模糊插询
    public void testMoFind(){
        List<Employee> employees=employeeDao.moFindByName();
        for (Employee emp:employees) {
            System.out.println(emp);
        }
    }
    @Test
    //分页插询
    public void testFindLimit(){
        List<Employee> employees=employeeDao.findLimit();
        for (Employee emp:employees) {
            System.out.println(emp);
        }
    }
    @Test
    //模糊加分页
    public void testMoFindLimit(){
        List<Employee> employees=employeeDao.moFindLimit();
        for (Employee emp:employees) {
            System.out.println(emp);
        }
    }
    @Test
    //批量添加
    public void testBatchInser(){
        Employee employee1 = new Employee("1","Giao爷爷","男",45,15000d);
        Employee employee2 = new Employee("2","Giao妈妈","女",40,16000d);
        Employee employee3 = new Employee("3","Giao儿子","男",18,17000d);
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(employee1);
        employeeList.add(employee2);
        employeeList.add(employee3);
        employeeDao.batchInserEmp(employeeList);
        for (Employee employee:employeeList) {
            System.out.println(employee);
        }
        System.out.println("总共添加："+employeeList.size()+"条数据");

    }
    @Test
    //批量修改
    public void testBatchUpdate(){
        List<Employee> employeeList=employeeDao.findAll();
        List<String> eids500=new ArrayList<>();//奖励500
        List<String> eids2000=new ArrayList<>();//奖励2000
        for (Employee employee:employeeList
             ) {
            if(employee.getSalary()>0&&employee.getSalary()<=10000){
                eids500.add(employee.getEid());
            }else {
                eids2000.add(employee.getEid());
            }
        }
        if(eids500.size()!=0){
            employeeDao.batchUpdateEmp("update employee set salary=salary+500 where eid=?",eids500);
        }
        if(eids2000.size()!=0){
            employeeDao.batchUpdateEmp("update employee set salary=salary+2000 where eid=?",eids2000);
        }
        System.out.println("成功修改"+(eids500.size()+eids2000.size())+"条数据");

    }
    @Test
    //批量删除
    public void testBatchDel(){
        List<String> eids=new ArrayList<>();
        eids.add("123608");
        eids.add("123609");
        eids.add("123610");
        boolean isOk=employeeDao.batchDeleteEmp(eids);
        if(isOk){
            System.out.println("成功删除"+eids.size()+"条数据");
        }else {
            System.out.println("删除失败");
        }

    }
    @Test
    //联合查询
    public void testLinkFind(){
        Employee employee=new Employee();
        List<Link> linkList=employeeDao.linkFind(employee);
        for (Link link:linkList) {
            System.out.println(linkList);
        }
    }
}
