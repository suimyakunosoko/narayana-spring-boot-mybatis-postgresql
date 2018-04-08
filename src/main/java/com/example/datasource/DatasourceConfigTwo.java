package com.example.datasource;

import java.util.Objects;
import java.util.function.Consumer;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import javax.transaction.TransactionManager;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.postgresql.xa.PGXADataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.expression.BeanFactoryAccessor;

import com.example.config.DataSourcePropertyBase;
import com.example.config.MyDataSourceProperties;


@Configuration
@EnableConfigurationProperties(MyDataSourceProperties.class)
@MapperScan(sqlSessionFactoryRef ="SqlSessionFactoryTwo" ,basePackages = "com.example.orm.two.dao")
public class DatasourceConfigTwo {
	
	@Autowired
	MyDataSourceProperties properties;
	
	@Bean
	public DataSource getDataSourceTwo() {
		return DataSourceUtil.getDataSource(properties.getProperty("datasourceTwo"), properties);
	}
	
	@Bean(name="SqlSessionFactoryTwo")
	public SqlSessionFactoryBean getSqlSessionFactoryTwo() {
		SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
		factory.setDataSource(getDataSourceTwo());
		return factory;
	}

}
