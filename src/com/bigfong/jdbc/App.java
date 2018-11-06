package com.bigfong.jdbc;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigfong.jdbc.dao.IEmployeeDAO;
import com.bigfong.jdbc.domain.Employee;





/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月28日 下午10:50:57
* @revision      $Id: 1.0  
*   
***********************************************************************/

@SpringJUnitConfig
public class App {
    
    @Autowired
    private IEmployeeDAO dao;
    
    @Test
    void testSave() throws Exception{
        Employee employee = new Employee();
        employee.setName("小六");
        employee.setAge(18);
        dao.save(employee);
    }
    
    @Test
    void testUpdate() throws Exception{
        Employee employee = new Employee();
        employee.setId(3L);
        employee.setName("小七仔");
        employee.setAge(38);
        dao.update(employee);
    }
    
    @Test
    void testDelete() throws Exception{
        dao.delete(6L);
    }
    
    @Test
    void testGet() throws Exception{
       Employee employee =  dao.get(1L);
       System.out.println(employee);
    }
    
    @Test
    void testGet2() throws Exception{
       Employee employee =  dao.get2(2L);
       System.out.println(employee);
    }
    
    @Test
    void testList() throws Exception{
        List<Employee> list =  dao.getList();
       System.out.println(list);
    }
}
