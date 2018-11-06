package com.bigfong.zhufang.tx;

/***********************************************************************   
* 模拟事务管理器
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:16:49
* @revision      $Id: 1.0  
*   
***********************************************************************/

public class TransactionManager {

    public void begin() {
        System.out.println("开启事务");
    }
    
    public void commit() {
        System.out.println("提交事务");
    }
    
    public void rollback() {
        System.out.println("回滚事务");
    }
}
