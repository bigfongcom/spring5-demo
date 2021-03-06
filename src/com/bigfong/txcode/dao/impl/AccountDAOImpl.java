package com.bigfong.txcode.dao.impl;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.bigfong.txcode.dao.IAccountDAO;


/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月1日 下午9:28:30
* @revision      $Id: 1.0  
*   
***********************************************************************/

@Repository
public class AccountDAOImpl implements IAccountDAO {

    private JdbcTemplate jdbcTemplate;
    
    @Autowired
    public void setDataSource(DataSource ds) {
        this.jdbcTemplate = new JdbcTemplate(ds);
    }
    
    @Override
    public void transOut(Long outId, int money) {
        System.out.println("outId:"+outId+",money:"+money);
        this.jdbcTemplate.update("update account set balance = balance - ? where id=?", money,outId);

    }

    @Override
    public void transIn(Long inId, int money) {
        System.out.println("inId:"+inId+",money:"+money);
        this.jdbcTemplate.update("update account set balance = balance + ? where id=?", money,inId);

    }

}
