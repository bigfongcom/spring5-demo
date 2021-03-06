package com.bigfong.javaconfig;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.bigfong.javaconfig.service.IAccountService;






/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月28日 下午10:50:57
* @revision      $Id: 1.0  
*   
***********************************************************************/

@SpringJUnitConfig(classes=AppConfig.class)
public class App {
    
    @Autowired
    private IAccountService service;
    
    @Test
    void testTrans() {
        service.trans(10002L, 10010L, 100);
    }
}
