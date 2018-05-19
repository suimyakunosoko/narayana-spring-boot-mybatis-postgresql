package com.example.constance;

public class DataBaseConst {

  public static class DataSourceOneConst {
    public static final String NAME = "SqlSessionFactoryOne";
    public static final String MAPPER = "com.example.orm.one.dao";
    public static final String DATA_SOURCE = "datasourceOne";
  }

  public static class DataSourceTwoConst {
    public static final String NAME = "SqlSessionFactoryTwo";
    public static final String MAPPER = "com.example.orm.two.dao";
    public static final String DATA_SOURCE = "datasourceTwo";
  }

  public static class DataSourceDefault {
    public static final String MAPPER = "com.example.orm.dao";
  }

}
