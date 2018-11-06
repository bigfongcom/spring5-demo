package com.bigfong.aopanno.tx;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/***********************************************************************   
* 模拟事务管理器
* @author        fenfenglee
* @create-time   2018年10月29日 下午10:16:49
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Component
@Aspect //配置切面
public class TransactionManager {
    //XML:<aop:pointcut id="txPoint" expression="execution(* com.bigfong.aopanno.service.*Service.*(..))" />
    @Pointcut("execution(* com.bigfong.aopanno.service.*Service.*(..))")
    public void txPoint() {
        
    }
    
    @Before("txPoint()")  //相当于调用上面的方法
    public void begin() {
        System.out.println("开启事务");
    }
    
    @AfterReturning("txPoint()")
    public void commit() {
        System.out.println("提交事务");
    }
    
    @AfterThrowing(value="txPoint()",throwing="ex")
    public void rollback(JoinPoint jp,Throwable ex) {
        System.out.println("回滚事务,异常信息:"+ex.getMessage());
    }
    
    @After("txPoint()")
    public void close() {
        System.out.println("释放资源");
    }
    
    @Around("txPoint()")
    public Object aroundMethod(ProceedingJoinPoint pjp) {
        Object ret = null;
        System.out.println("环绕增强:开启事务");
        try {
            ret = pjp.proceed();//调用真实对象的方法
            System.out.println("环绕增强:正常执行真实方法");
        }catch (Throwable e) {
            System.out.println("环绕增强:回滚事务，异常信息:"+e.getMessage());
        }finally {
            System.out.println("环绕增强:释放资源");
        }
        return ret;
    }
}
