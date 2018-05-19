package com.example.datasource;

import com.example.common.DataSourceUtil;
import com.example.config.MyDataBaseProperties;
import com.example.constance.DataBaseConst;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@EnableConfigurationProperties(MyDataBaseProperties.class)
@MapperScan(sqlSessionFactoryRef = DataBaseConst.DataSourceOneConst.NAME,
    basePackages = DataBaseConst.DataSourceOneConst.MAPPER)
public class DatasourceConfigOne {

  @Autowired
  MyDataBaseProperties properties;

  @Autowired
  MybatisProperties mybatisProperty;

  /**
   * Get dataSource one.
   * 
   * @return
   */
  @Primary
  @Bean
  public DataSource getDataSourceOne() {
    return DataSourceUtil.getDataSource(
        this.properties.getProperty(DataBaseConst.DataSourceOneConst.DATA_SOURCE).getDetail());
  }

  /**
   * Get SqlSessionFactory one.
   * 
   * @return
   */
  @Primary
  @Bean(name = DataBaseConst.DataSourceOneConst.NAME)
  public SqlSessionFactoryBean getSqlSessionFactoryOne() {
    SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
    factory.setConfiguration(this.mybatisProperty.getConfiguration());
    factory.setDataSource(getDataSourceOne());
    return factory;
  }


}
