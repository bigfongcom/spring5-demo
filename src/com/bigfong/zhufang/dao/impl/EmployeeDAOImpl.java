package com.bigfong.zhufang.dao.impl;

import com.bigfong.zhufang.dao.IEmployeeDAO;
import com.bigfong.zhufang.domain.Employee;

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
        System.out.println("保存");
    }

    @Override
    public void update(Employee emp) {
        System.out.println("修改");
    }

}
