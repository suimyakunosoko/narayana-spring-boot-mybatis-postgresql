package com.example.common;

import java.util.Objects;
import org.postgresql.xa.PGXADataSource;

/**
 * Extends PGXADataSource for TransactionalDriver.
 * 
 * @author suimyakunosoko
 *
 */
public class MyXaDataSource extends PGXADataSource {

  /** enable pool connection. */
  private boolean poolConnections = true;

  /** max pool connection counts. */
  private int maxConnections = 10;

  public String getDynamicClass() {
    return this.getClass().getName();
  }

  public boolean getPoolConnections() {
    return this.poolConnections;
  }

  public void setPoolConnections(boolean poolConnections) {
    this.poolConnections = poolConnections;
  }

  public int getMaxConnections() {
    return this.maxConnections;
  }

  public void setMaxConnections(int maxConnections) {
    this.maxConnections = maxConnections;
  }

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof MyXaDataSource)) {
      return false;
    }
    MyXaDataSource casted = (MyXaDataSource) obj;
    return Objects.equals(casted.getURL(), this.getURL())
        && Objects.equals(casted.getUser(), this.getUser())
        && Objects.equals(casted.getPassword(), this.getPassword());
  }

}
