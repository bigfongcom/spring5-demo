package com.bigfong.test;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年10月28日 下午7:25:52
* @revision      $Id: 1.0  
*   
***********************************************************************/

@SpringJUnitConfig
public class ContainerTest {

    @Autowired
    public SomeBean someBean;
    
    @Autowired
    public BeanFactory beanFactory;
    
    @Autowired
    public ApplicationContext applicationContext;
    
    @Test
    public void test1() throws Exception {
        System.out.println(someBean);
    }
}
