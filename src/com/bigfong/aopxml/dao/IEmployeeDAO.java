package com.bigfong.aopxml.dao;

import com.bigfong.aopxml.domain.Employee;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:07:26
* @revision      $Id: 1.0  
*   
***********************************************************************/

public interface IEmployeeDAO {
    void save(Employee emp);
    void update(Employee emp);
}
