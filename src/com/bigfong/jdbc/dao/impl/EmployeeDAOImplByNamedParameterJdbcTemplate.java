package com.bigfong.jdbc.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.aspectj.weaver.patterns.ThisOrTargetAnnotationPointcut;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;

import com.bigfong.jdbc.dao.IEmployeeDAO;
import com.bigfong.jdbc.domain.Employee;




/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:10:18
* @revision      $Id: 1.0  
*   
***********************************************************************/


public class EmployeeDAOImplByNamedParameterJdbcTemplate implements IEmployeeDAO {

    
    //属性:dataSource
    private NamedParameterJdbcTemplate jdbcTemplate;

    public void setDataSource(DataSource dataSource) {
        this.jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
    }

    @Override
    public void save(Employee emp) {
        System.out.println("保存员工-ByNamedParameterJdbcTemplate");
        this.jdbcTemplate.update("INSERT INTO employee (name,age) VALUES (:name,:age)", new HashMap() {{
            this.put("name",emp.getName());
            this.put("age",emp.getAge());
         }});
    }

    @Override
    public void update(Employee emp) {
        System.out.println("修改员工-ByNamedParameterJdbcTemplate");
        this.jdbcTemplate.update("UPDATE employee SET name=:name,age=:age WHERE id=:id", new HashMap() {{
            this.put("id",emp.getId());
            this.put("name",emp.getName());
            this.put("age",emp.getAge());
         }});
    }

    @Override
    public void delete(Long id) {
        System.out.println("删除员工-ByNamedParameterJdbcTemplate");
        this.jdbcTemplate.update("DELETE FROM employee   WHERE id=:id", new HashMap() {{
                this.put("id",id);
        }});
    }

    /*
     * 注：该例子下，使用queryForObject查找单条记录，如果数据不存在，会抛出异常
     */
    @Override
    public Employee get(Long id) {
        Employee emp = this.jdbcTemplate.queryForObject(
                "select id,name,age from employee where id =:id",
                new HashMap() {{
                   this.put("id",id);
                }},
                new RowMapper<Employee>() {
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Employee emp = new Employee();
                        emp.setId(rs.getLong("id"));
                        emp.setName(rs.getString("name"));
                        emp.setAge(rs.getInt("age"));
                        return emp;
                    }
                });
        return emp;
    }
    
    @Override
    public Employee get2(Long id) {
        List<Employee> list = this.jdbcTemplate.query(
                "select id,name,age from employee where id =:id",
                new HashMap() {{
                    this.put("id",id);
                 }},
                new RowMapper<Employee>() {
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Employee emp = new Employee();
                        emp.setId(rs.getLong("id"));
                        emp.setName(rs.getString("name"));
                        emp.setAge(rs.getInt("age"));
                        return emp;
                    }
                });
        return list.size()==1?list.get(0):null;
    }

    @Override
    public List<Employee> getList() {
        List<Employee> list = this.jdbcTemplate.query(
                "select id,name,age from employee",
                new RowMapper<Employee>() {
                    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
                        Employee emp = new Employee();
                        emp.setId(rs.getLong("id"));
                        emp.setName(rs.getString("name"));
                        emp.setAge(rs.getInt("age"));
                        return emp;
                    }
                });
        return list;
    }

}
