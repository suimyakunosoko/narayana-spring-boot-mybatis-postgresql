package com.example.datasource;

import java.util.Objects;
import java.util.function.Consumer;

import javax.sql.DataSource;
import javax.sql.XADataSource;
import javax.transaction.TransactionManager;

import org.apache.commons.dbcp2.PoolableConnection;
import org.apache.commons.dbcp2.PoolableConnectionFactory;
import org.apache.commons.dbcp2.managed.DataSourceXAConnectionFactory;
import org.apache.commons.dbcp2.managed.ManagedDataSource;
import org.apache.commons.pool2.impl.GenericObjectPool;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.postgresql.xa.PGXADataSource;
import org.apache.ibatis.mapping.Environment;

import com.arjuna.ats.jta.common.jtaPropertyManager;
import com.example.config.DataSourcePropertyBase;
import com.example.config.MyDataSourceProperties;

public class DataSourceUtil {
	
	public static DataSource getDataSource(DataSourcePropertyBase tgt, DataSourcePropertyBase base) {
		TransactionManager tm = jtaPropertyManager.getJTAEnvironmentBean().getTransactionManager();
		XADataSource xaDataSource = getXADataSource(tgt, base);
        DataSourceXAConnectionFactory dataSourceXAConnectionFactory =
                new DataSourceXAConnectionFactory(tm, xaDataSource);
        PoolableConnectionFactory poolableConnectionFactory =
                new PoolableConnectionFactory(dataSourceXAConnectionFactory, null);
        GenericObjectPool<PoolableConnection> connectionPool =
                new GenericObjectPool<>(poolableConnectionFactory);
        poolableConnectionFactory.setPool(connectionPool);
        return new ManagedDataSource<>(connectionPool,
                dataSourceXAConnectionFactory.getTransactionRegistry());
	}
	
	public static XADataSource getXADataSource(DataSourcePropertyBase tgt, DataSourcePropertyBase base) {
		PGXADataSource datasource = new PGXADataSource();
		defaultIfEmpty(tgt.getUrl(), base.getUrl(), datasource::setUrl);
		defaultIfEmpty(tgt.getUser(), base.getUser(), datasource::setUser);
		defaultIfEmpty(tgt.getPassword(), base.getPassword(), datasource::setPassword);
		
		return datasource;
	}
	
	private static<T> void defaultIfEmpty(T tgt, T def, Consumer<T> consumer) {
		if (tgt != null) {
			consumer.accept(tgt);
		} else if (def != null) {
			consumer.accept(def);
		}
		return;
	}

}
