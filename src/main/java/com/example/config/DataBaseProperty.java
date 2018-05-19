package com.example.config;

import com.example.common.MyDataSource;

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
  private MyDataSource detail;

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public MyDataSource getDetail() {
    return this.detail;
  }

  public void setDetail(MyDataSource detail) {
    this.detail = detail;
  }
}
