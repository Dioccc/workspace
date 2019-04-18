package com.dx.dao.impl;

import com.dx.dao.EmployeeDao;
import com.dx.po.Employee;
import com.dx.po.Link;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BatchPreparedStatementSetter;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository("employeeDao")
public class EmployeeDaoImpl extends JdbcDaoSupport implements EmployeeDao {
    //注入数据源
    @Autowired
    public EmployeeDaoImpl(DataSource dataSource){
        super.setDataSource(dataSource);
    }
    @Override
    public int addEmployee(Employee employee) {
        String sql="insert into employee(did,name,sex,age,salary) value(?,?,?,?,?)";
        Object[] obj=new Object[] {
                employee.getDid(),
                employee.getName(),
                employee.getSex(),
                employee.getAge(),
                employee.getSalary()
        };
        int num=this.getJdbcTemplate().update(sql,obj);
        return num;
    }
    //更新用户
    @Override
    public int updateEmployee(Employee employee) {
        String sql="update employee set did=?,name=?,sex=?,age=?,salary=? where eid=123547";
        Object[] params=new Object[] {
                employee.getDid(),
                employee.getName(),
                employee.getSex(),
                employee.getAge(),
                employee.getSalary()
        };
        int num=this.getJdbcTemplate().update(sql,params);
        return num;
    }
    //删除用户
    @Override
    public int deleteEmployee(String eid) {
        String sql="delete from employee where eid=?";
        int num=this.getJdbcTemplate().update(sql,eid);
        return num;
    }

    @Override
    public Employee findEmployee(String eid) {
        String sql="select * from employee where eid=?";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
        return this.getJdbcTemplate().queryForObject(sql, rowMapper,eid);

    }

    @Override
    public List<Employee> findAll() {
        String sql="SELECT * FROM employee";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<>(Employee.class);
        return this.getJdbcTemplate().query(sql,rowMapper);
    }
    //转账
    @Override
    public boolean transfer(String outUser, String inUser, Double money) {
        //收款时，收款用户+金额
        this.getJdbcTemplate().update("update employee set salary =salary +?"+"where eid =?",money,inUser);
        //收款时，收款用户-金额
        this.getJdbcTemplate().update("update employee set salary =salary -?"+"where eid =?",money,outUser);
        return true;
    }
    //模糊查询
    @Override
    public List<Employee> moFindByName() {
        String sql="select * from employee where name like '%i%'";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
        return this.getJdbcTemplate().query(sql, rowMapper);
    }
    //分页查询
    @Override
    public List<Employee> findLimit() {
        String sql="SELECT * from employee LIMIT 0,4";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
        return this.getJdbcTemplate().query(sql, rowMapper);

    }
    //模糊加分页
    @Override
    public List<Employee> moFindLimit() {
        String sql="SELECT * FROM employee where NAME LIKE '%i%' ORDER BY salary DESC LIMIT 2,8; ";
        RowMapper<Employee> rowMapper=new BeanPropertyRowMapper<Employee>(Employee.class);
        return this.getJdbcTemplate().query(sql, rowMapper);
    }
    // 批量添加
    @Override
    public boolean batchInserEmp(List<Employee> employeeList) {
        String sql="insert into employee values(?,?,?,?,?,?)";
        int[] isOK = this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter(){
            public int getBatchSize() {
                return employeeList.size();
            }

            public void setValues(PreparedStatement ps, int i)throws SQLException {
                ps.setString(1, employeeList.get(i).getEid());
                ps.setString(2,employeeList.get(i).getDid());
                ps.setString(3,employeeList.get(i).getName());
                ps.setString(4,employeeList.get(i).getSex());
                ps.setInt(5,employeeList.get(i).getAge());
                ps.setDouble(6,employeeList.get(i).getSalary());
            }});
        return isOK.length>0;
    }
    // 批量修改
    @Override
    public boolean batchUpdateEmp(String sql,List<String> eids) {
        int[] isOK = this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter(){
            public int getBatchSize() {
                return eids.size();
            }

            public void setValues(PreparedStatement ps, int i)throws SQLException {
                ps.setString(1, eids.get(i));

            }});
        return isOK.length>0;
    }
    // 批量删除
    @Override
    public boolean batchDeleteEmp(List<String> eids) {
        String sql="delete from employee where eid=?";
        int[] isOK = this.getJdbcTemplate().batchUpdate(sql, new BatchPreparedStatementSetter(){
            public int getBatchSize() {
                return eids.size();
            }

            public void setValues(PreparedStatement ps, int i)throws SQLException {
                ps.setString(1, eids.get(i));
            }});
        return isOK.length>0;
    }
    //联合查询
    @Override
    public List<Link> linkFind(Employee employee) {
        String sql="SELECT cname,dname,name,age,sex,salary FROM employee join department on employee.did=department.did JOIN company ON company.cid=department.cid where eid='1'";
        RowMapper<Link> rowMapper=new BeanPropertyRowMapper<>(Link.class);
        return this.getJdbcTemplate().query(sql,rowMapper);
    }


}
