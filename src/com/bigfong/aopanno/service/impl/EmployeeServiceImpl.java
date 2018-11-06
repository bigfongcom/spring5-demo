package com.bigfong.aopanno.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bigfong.aopanno.dao.IEmployeeDAO;
import com.bigfong.aopanno.domain.Employee;
import com.bigfong.aopanno.service.IEmployeeService;




/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:13:48
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Service
public class EmployeeServiceImpl implements IEmployeeService {
    
    @Autowired
    private IEmployeeDAO dao;
    

    @Override
    public void save(Employee emp) {
        dao.save(emp);
        System.out.println("保存成功");
    }

    @Override
    public void update(Employee emp) {
        dao.update(emp);
        //System.out.println("修改成功");
        throw new RuntimeException("故意出错");
    }

}
