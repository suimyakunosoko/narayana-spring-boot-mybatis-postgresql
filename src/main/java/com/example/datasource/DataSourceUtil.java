package com.example.datasource;

import java.util.function.Consumer;

import javax.sql.DataSource;
import javax.sql.XADataSource;

import org.postgresql.xa.PGXADataSource;
import org.springframework.boot.jta.narayana.NarayanaDataSourceBean;

import com.example.config.DataSourcePropertyBase;

public class DataSourceUtil {
	
	public static DataSource getDataSource(DataSourcePropertyBase tgt, DataSourcePropertyBase base) {
		XADataSource xaDataSource = getXADataSource(tgt, base);
		NarayanaDataSourceBean dataSource = new NarayanaDataSourceBean(xaDataSource);
		return dataSource;
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
