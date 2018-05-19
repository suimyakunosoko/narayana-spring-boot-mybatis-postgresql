package com.example.config;

import com.example.common.MyXaDataSource;

/**
 * DB setting for Mybatis and PostgreSql.
 * 
 * @author suimyakunosoko
 *
 */
public class DataBaseProperty {

  /** DataBase setting name. */
  private String name;

  /** DataSource property. */
  private MyXaDataSource detail;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MyXaDataSource getDetail() {
    return this.detail;
  }

  public void setDetail(MyXaDataSource detail) {
    this.detail = detail;
  }
}
