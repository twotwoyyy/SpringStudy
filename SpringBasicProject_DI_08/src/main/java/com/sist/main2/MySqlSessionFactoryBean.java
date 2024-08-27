package com.sist.main2;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
/*
 * 	<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
		p:dataSource-ref="ds"
	/>
 */
@Component("ssf")
public class MySqlSessionFactoryBean  extends SqlSessionFactoryBean{
	@Autowired // �ڵ� ���� 
	public MySqlSessionFactoryBean(DataSource datasource) {
		setDataSource(datasource);
	}
}
