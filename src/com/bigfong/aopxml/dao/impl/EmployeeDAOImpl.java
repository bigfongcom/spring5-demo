package com.bigfong.aopxml.dao.impl;

import com.bigfong.aopxml.dao.IEmployeeDAO;
import com.bigfong.aopxml.domain.Employee;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:10:18
* @revision      $Id: 1.0  
*   
***********************************************************************/

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
