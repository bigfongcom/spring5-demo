package com.bigfong.aopanno.service;

import com.bigfong.aopanno.domain.Employee;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:12:21
* @revision      $Id: 1.0  
*   
***********************************************************************/

public interface IEmployeeService {
    void save(Employee emp);
    void update(Employee emp);
}
