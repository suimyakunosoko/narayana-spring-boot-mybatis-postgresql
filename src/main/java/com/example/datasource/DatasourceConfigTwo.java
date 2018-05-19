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


@Configuration
@EnableConfigurationProperties(MyDataBaseProperties.class)
@MapperScan(sqlSessionFactoryRef = DataBaseConst.DataSourceTwoConst.NAME,
    basePackages = DataBaseConst.DataSourceTwoConst.MAPPER)
public class DatasourceConfigTwo {

  @Autowired
  MyDataBaseProperties properties;

  @Autowired
  MybatisProperties mybatisProperty;

  /**
   * Get dataSource one.
   * 
   * @return
   */
  @Bean
  public DataSource getDataSourceTwo() {
    return DataSourceUtil.getDataSource(
        this.properties.getProperty(DataBaseConst.DataSourceTwoConst.DATA_SOURCE).getDetail());
  }

  /**
   * Get SqlSessionFactory one.
   * 
   * @return
   */
  @Bean(name = DataBaseConst.DataSourceTwoConst.NAME)
  public SqlSessionFactoryBean getSqlSessionFactoryTwo() {
    SqlSessionFactoryBean factory = new SqlSessionFactoryBean();
    factory.setConfiguration(this.mybatisProperty.getConfiguration());
    factory.setDataSource(getDataSourceTwo());
    return factory;
  }

}
