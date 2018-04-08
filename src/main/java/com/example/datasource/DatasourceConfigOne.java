package com.example.datasource;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import com.example.config.MyDataSourceProperties;

@Configuration
@EnableConfigurationProperties(MyDataSourceProperties.class)
@MapperScan(sqlSessionFactoryRef ="SqlSessionFactoryOne" ,basePackages = "com.example.orm.one.dao")
public class DatasourceConfigOne {
	
	@Autowired
	MyDataSourceProperties properties;
	
	@Primary
	@Bean
	public DataSource getDataSourceOne() {
		return DataSourceUtil.getDataSource(properties.getProperty("datasourceOne"), properties);
	}
	
	@Primary
	@Bean(name="SqlSessionFactoryOne")
	public SqlSessionFactoryBean getSqlSessionFactoryOne() {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(getDataSourceOne());
		return factory;
	}
	

}
