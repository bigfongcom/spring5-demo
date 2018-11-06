package com.bigfong.aopanno.dao.impl;

import org.springframework.stereotype.Repository;

import com.bigfong.aopanno.dao.IEmployeeDAO;
import com.bigfong.aopanno.domain.Employee;


/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:10:18
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Repository
public class EmployeeDAOImpl implements IEmployeeDAO {

    @Override
    public void save(Employee emp) {
        System.out.println("保存员工");
        
    }

    @Override
    public void update(Employee emp) {
        System.out.println("修改员工");
    }

}
