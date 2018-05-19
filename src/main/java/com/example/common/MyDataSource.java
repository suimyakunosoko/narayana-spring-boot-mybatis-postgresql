package com.example.common;

import javax.naming.Reference;
import org.postgresql.ds.common.BaseDataSource;

public class MyDataSource extends BaseDataSource {

  private String url;

  private Reference reference;


  @Override
  public String getUrl() {
    return this.url;
  }


  @Override
  public void setUrl(String url) {
    this.url = url;
    super.setUrl(url);
  }


  @Override
  public String getURL() {
    // TODO 自動生成されたメソッド・スタブ
    return getUrl();
  }


  @Override
  public void setURL(String url) {
    // TODO 自動生成されたメソッド・スタブ
    setUrl(url);
  }


  @Override
  public Reference getReference() {
    return this.reference;
  }


  public void setReference(Reference reference) {
    this.reference = reference;
  }


  @Override
  public String getDescription() {
    // TODO 自動生成されたメソッド・スタブ
    return null;
  }

}
