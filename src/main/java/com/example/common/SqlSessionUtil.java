package com.example.common;

import com.example.config.MyDataBaseProperties;
import com.example.constance.DataBaseConst;
import java.util.Objects;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.TransactionFactory;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.boot.autoconfigure.MybatisProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SqlSessionUtil {

  @Autowired
  MyDataBaseProperties properties;

  @Autowired
  MybatisProperties mybatisProperty;

  @Autowired
  SqlSessionManager manager;

  /**
   * create SqlSessionFactory by DataBase name.
   * 
   * @param name DataBase name
   * @return
   */
  public SqlSessionFactory getSqlSessionFactory(String name) {
    return getSqlSessionFactory(name, null);
  }

  /**
   * <p>
   * create SqlSessionFactory by DataBase name.
   * </p>
   * <p>
   * when no DataBase name on yml, create SqlSessionFactory by defBase.
   * </p>
   * 
   * @param name DataBase name
   * @param defBase use when yml dose not contain DataBaseName
   * @return
   */
  public SqlSessionFactory getSqlSessionFactory(String name, String defBase) {
    XADataSource dataSourceprop = this.properties.getProperty(name, defBase).getDetail();
    DataSource dataSource = DataSourceUtil.getDataSource(dataSourceprop);

    TransactionFactory transactionFactory = new JdbcTransactionFactory();
    Environment environment = new Environment("development", transactionFactory, dataSource);
    Configuration configuration = DataSourceUtil.fillNullByDefault(new Configuration(environment),
        this.mybatisProperty.getConfiguration());
    configuration.addMappers(DataBaseConst.DataSourceDefault.MAPPER);
    return new SqlSessionFactoryBuilder().build(configuration);
  }

  /**
   * Get SqlSession by name.
   * 
   * @param name DataBase name
   * @return
   */
  public SqlSession getSqlSession(String name) {
    return getSqlSession(name, null);
  }

  /**
   * <p>
   * create SqlSession by DataBase name.
   * </p>
   * <p>
   * when no DataBase name on yml, create SqlSession by defBase.
   * </p>
   * 
   * @param name DataBase name
   * @param defBase use when yml dose not contain DataBaseName
   * @return
   */
  public SqlSession getSqlSession(String name, String defBase) {
    SqlSession session = this.manager.get(name);
    if (!Objects.isNull(session)) {
      return session;
    }
    session = getSqlSessionFactory(name, defBase).openSession();
    this.manager.put(name, session);

    return session;
  }

}
