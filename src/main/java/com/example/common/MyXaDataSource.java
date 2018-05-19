package com.example.common;

import java.util.Objects;
import org.postgresql.xa.PGXADataSource;

public class MyXaDataSource extends PGXADataSource {

  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof MyXaDataSource)) {
      return false;
    }
    MyXaDataSource casted = (MyXaDataSource) obj;
    return Objects.equals(casted.getURL(), this.getURL())
        && Objects.equals(casted.getUser(), this.getUser());
  }

}
