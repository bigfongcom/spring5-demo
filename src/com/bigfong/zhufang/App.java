package com.bigfong.zhufang;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigfong.zhufang.domain.Employee;
import com.bigfong.zhufang.service.IEmployeeService;

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
    private IEmployeeService service;
    
    @Test
    public void testSave()throws Exception {
        service.save(new Employee());
    }
    
    @Test
    public void testUpdate()throws Exception {
        service.update(new Employee());
    }
}
