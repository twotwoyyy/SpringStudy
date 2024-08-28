package com.sist.config;

import javax.sql.DataSource;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

@Configuration
@ComponentScan(basePackages = {"com.sist.*"})
public class EmpConfig {
	@Bean("ds")
	public DataSource dataSource() {
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("org.apache.commons.dbcp.BasicDataSource");
		ds.setUrl("jdbc:oracle:thin:@localhost:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	/*
	 * 	<bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
			p:dataSource-ref="ds"
			p:configLocation="classpath:Config.xml"
		/>
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		ssf.setDataSource(dataSource());
		return ssf.getObject();
	}
	
	/*
	 * 	<bean id="mapper" class="org.mybatis.spring.mapper.MapperFactoryBean"
			p:sqlSessionFactory-ref="ssf"
			p:mapperInterface="com.sist.mapper.EmpMapper"
		/>
	 */
	@Bean("mapper")
	public MapperFactoryBean mapperFactoryBean() {
		MapperFactoryBean mapper=new MapperFactoryBean();
		try {
			mapper.setSqlSessionFactory(sqlSessionFactory());
			mapper.setMapperInterface(com.sist.mapper.EmpMapper.class);
		}catch(Exception ex) {
			
		}
		return mapper;
	}
	
	/*
	 * 	<bean id="dao" class="com.sist.dao.EmpDAO2"
			p:mapper-ref="mapper"
		/>
	 */

}
