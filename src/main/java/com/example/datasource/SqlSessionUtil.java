package com.example.datasource;

import java.util.Objects;

import javax.sql.DataSource;

import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.config.DataSourcePropertyBase;
import com.example.config.MyDataSourceProperties;

@Component
public class SqlSessionUtil {
	
	@Autowired
	MyDataSourceProperties properties;
	
	public SqlSessionFactory getSqlSessionFactory(String name) {
		return getSqlSessionFactory(name, null);
	}
	

	
	public SqlSessionFactory getSqlSessionFactory(String name, String sufixUrl) {
		DataSourcePropertyBase prop = properties.getProperty(name);
		if (!Objects.isNull(sufixUrl)) {
			prop = prop.clone();
			prop.setUrl(prop.getUrl() + sufixUrl);
		}
		DataSource dataSource = DataSourceUtil.getDataSource(prop, properties);
		
		TransactionFactory transactionFactory = new JdbcTransactionFactory();
		org.apache.ibatis.mapping.Environment environment = new Environment("development", transactionFactory, dataSource);
		Configuration configuration = new Configuration(environment);
//		for (Class<?> clazz : classes) {
//			configuration.addMapper(clazz);
//		}
		configuration.addMappers("com.example.orm.dao");
		return new SqlSessionFactoryBuilder().build(configuration);
	}

}
