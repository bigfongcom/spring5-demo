package com.bigfong.javaconfig;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/***********************************************************************   
* 当前项目的配置类,好比是applicationContext.xml文件
* @author        fenfenglee
* @create-time   2018年11月2日 下午8:06:28
* @revision      $Id: 1.0  
*   
***********************************************************************/
@Configuration  //标记当前类为一个配置类
@Import(DataSourceConfig.class)  //包含其他的配置类
@ComponentScan //默认扫描当前所在的包及子包   IOC注解解析
@EnableTransactionManagement //事务注解解析器
public class AppConfig {
    
    //创建事务管理器的Bean,参数所需的DataSource ds,spring会自动在整个IOC容器中找，并注入进去
    @Bean
    public DataSourceTransactionManager txManager(DataSource ds) {
        return new DataSourceTransactionManager(ds);
    }

}
