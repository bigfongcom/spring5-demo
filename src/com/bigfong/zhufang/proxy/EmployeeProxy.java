package com.bigfong.zhufang.proxy;

import org.springframework.beans.factory.annotation.Autowired;

import com.bigfong.zhufang.domain.Employee;
import com.bigfong.zhufang.service.IEmployeeService;
import com.bigfong.zhufang.tx.TransactionManager;

/***********************************************************************   
* 静态代理类
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:42:01
* @revision      $Id: 1.0  
*   
***********************************************************************/

public class EmployeeProxy implements IEmployeeService{
    
    private IEmployeeService target;//真实对像/委托对象
   
    private TransactionManager txManager;//事务管理器
    
    public void setTarget(IEmployeeService target) {
        this.target = target;
    }
    public void setTxManager(TransactionManager txManager) {
        this.txManager = txManager;
    }

    @Override
    public void save(Employee emp) {
        txManager.begin();
        try {
            target.save(emp);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        }
        
    }

    @Override
    public void update(Employee emp) {
        txManager.begin();
        try {
            target.update(emp);
            txManager.commit();
        } catch (Exception e) {
            e.printStackTrace();
            txManager.rollback();
        }
    }

}
