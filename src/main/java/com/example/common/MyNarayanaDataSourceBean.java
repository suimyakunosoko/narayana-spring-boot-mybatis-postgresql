package com.example.common;

import com.arjuna.ats.internal.jdbc.ConnectionManager;
import com.arjuna.ats.jdbc.TransactionalDriver;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;
import org.springframework.boot.jta.narayana.NarayanaDataSourceBean;

/**
 * Wrap NarayanaDataSourceBean for ConnectionManager and enable TransactionalDriverProperties.
 * 
 * @author suimyakunosoko
 *
 */
public class MyNarayanaDataSourceBean extends NarayanaDataSourceBean {

  private final Properties properties;

  /**
   * Wrap NarayanaDataSourceBean for ConnectionManager.
   * 
   * @param myXaDataSource MyXaDataSource
   */
  public MyNarayanaDataSourceBean(MyXaDataSource myXaDataSource) {
    super(myXaDataSource);
    this.properties = new Properties();
    this.properties.put(TransactionalDriver.userName, myXaDataSource.getUser());
    this.properties.put(TransactionalDriver.password, myXaDataSource.getPassword());
    this.properties.put(TransactionalDriver.dynamicClass, myXaDataSource.getDynamicClass());
    this.properties.put(TransactionalDriver.poolConnections,
        String.valueOf(myXaDataSource.getPoolConnections()));
    this.properties.put(TransactionalDriver.XADataSource, myXaDataSource);
    this.properties.put(TransactionalDriver.maxConnections,
        String.valueOf(myXaDataSource.getMaxConnections()));
  }

  @Override
  public Connection getConnection() throws SQLException {
    return ConnectionManager.create(null, this.properties);
  }

  @Override
  public Connection getConnection(String username, String password) throws SQLException {
    return ConnectionManager.create(null, this.properties);
  }

}
