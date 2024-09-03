package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

// ȯ�漳��, Ŭ���� ��� ���� 
// application-datasource.xml (����� ����)
@Configuration
@MapperScan(basePackages = {"com.sist.mapper"})
// <mybatis-spring base-package="">
public class DataBaseConfig {
	// �����ͺ��̽� ���� ���� => Datasource : interface => ������ Ŭ���� BasicDataSource
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	// MyBatis => JPA ���� => SqlSessionFactory => ������ Ŭ���� SqlSessionFactoryBuilder
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf=
				new SqlSessionFactoryBean();
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	// Mapper ���� MapperFactoryBean
	
}
