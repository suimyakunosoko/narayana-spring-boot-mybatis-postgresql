package com.example.config;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@ConfigurationProperties("my.datasources")
public class MyDataSourceProperties extends DataSourcePropertyBase {
	
	/** データベースの一覧を設定 */
	List<DataSourcePropertyBase> list;

	public List<DataSourcePropertyBase> getList() {
		return list;
	}

	public void setList(List<DataSourcePropertyBase> list) {
		this.list = list;
	}
	
	public DataSourcePropertyBase getProperty(String name) {
		Optional<DataSourcePropertyBase> optional = getList().stream()
				.filter(prop -> Objects.equals(name, prop.getName())).findFirst();
		return optional.orElseGet(null);
	}
	
}
