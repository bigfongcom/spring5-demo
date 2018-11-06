package com.bigfong.txxml.service.impl;

import org.springframework.stereotype.Service;

import com.bigfong.txxml.dao.IAccountDAO;
import com.bigfong.txxml.service.IAccountService;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月1日 下午9:36:27
* @revision      $Id: 1.0  
*   
***********************************************************************/

public class AccountServiceImpl implements IAccountService {

    private IAccountDAO dao;
    
    public void setDao(IAccountDAO dao) {
        this.dao = dao;
    }
    
    @Override
    public void trans(Long outId, Long inId, int money) {
        //转出
        this.dao.transOut(outId, money);
        //转入
        int a = 1/0;//模拟异常
        this.dao.transIn(inId, money);

    }

}
