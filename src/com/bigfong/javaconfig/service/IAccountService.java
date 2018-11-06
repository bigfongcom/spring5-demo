package com.bigfong.javaconfig.service;

/***********************************************************************   
*
* @author        fenfenglee
* @create-time   2018年11月1日 下午9:34:37
* @revision      $Id: 1.0  
*   
***********************************************************************/

public interface IAccountService {
    /**
     * 从指定帐户转出另一个帐户多少钱
     * @param outId
     * @param inId
     * @param money
     */
    void trans(Long outId,Long inId,int money);
}
