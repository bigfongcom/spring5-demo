package com.bigfong.zhufang.service.impl;

import javax.management.RuntimeErrorException;

import com.bigfong.zhufang.dao.IEmployeeDAO;
import com.bigfong.zhufang.domain.Employee;
import com.bigfong.zhufang.service.IEmployeeService;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:13:48
* @revision      $Id: 1.0  
*   
***********************************************************************/

public class EmployeeServiceImpl implements IEmployeeService {

    private IEmployeeDAO dao;
    
    public void setDao(IEmployeeDAO dao) {
        this.dao = dao;
    }
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
