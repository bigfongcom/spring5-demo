package com.bigfong.txcode.dao;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月1日 下午9:26:28
* @revision      $Id: 1.0  
*   
***********************************************************************/

public interface IAccountDAO {

    /**
     * 从指定帐户转出多少钱
     * @param outId
     * @param money
     */
    void transOut(Long outId,int money);
    
    /**
     * 从指定帐户转入多少钱
     * @param inId
     * @param money
     */
    void transIn(Long inId,int money);
}
