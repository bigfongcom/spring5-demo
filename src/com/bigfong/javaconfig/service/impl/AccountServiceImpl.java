package com.bigfong.javaconfig.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bigfong.javaconfig.dao.IAccountDAO;
import com.bigfong.javaconfig.service.IAccountService;



/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月1日 下午9:36:27
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Service
@Transactional
public class AccountServiceImpl implements IAccountService {

    @Autowired
    private IAccountDAO dao;

    
    @Override
    public void trans(Long outId, Long inId, int money) {
        //转出
        this.dao.transOut(outId, money);
        //转入
        int a = 1/0;//模拟异常
        this.dao.transIn(inId, money);

    }

}
