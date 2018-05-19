package com.example.config;

import com.example.common.DataSourceUtil;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("my.datasources")
public class MyDataBaseProperties {

  /** default DB property. */
  private DataBaseProperty defaultProperty;

  public DataBaseProperty getDefaultProperty() {
    return this.defaultProperty;
  }

  public void setDefaultProperty(DataBaseProperty defaultProperty) {
    this.defaultProperty = defaultProperty;
  }

  /** DB setting list. */
  private List<DataBaseProperty> list;

  public List<DataBaseProperty> getList() {
    return this.list;
  }

  public void setList(List<DataBaseProperty> list) {
    this.list = list;
  }

  /**
   * get DB property by name.
   * 
   * @param name DB name
   * @return DB property
   */
  public DataBaseProperty getProperty(String name) {
    return getProperty(name, null);
  }

  /**
   * get DB property by name.
   * 
   * @param name DB name
   * @return DB property
   */
  public DataBaseProperty getProperty(String name, String defBase) {
    DataBaseProperty defProp = new DataBaseProperty();
    Optional<DataBaseProperty> rtn =
        getList().stream().filter(prop -> Objects.equals(name, prop.getName())).findFirst();
    if (rtn.isPresent()) {
      return DataSourceUtil.fillNullByDefault(rtn.get(), getDefaultProperty());
    } else if (!Objects.isNull(defBase)) {
      defProp = getList().stream().filter(prop -> Objects.equals(defBase, prop.getName()))
          .findFirst().orElseGet(DataBaseProperty::new);
    }
    DataBaseProperty prop = DataSourceUtil.fillNullByDefault(defProp, getDefaultProperty());
    prop.setName(name);
    prop.getDetail().setDatabaseName(prop.getDetail().getDatabaseName() + name);
    return prop;
  }

  public boolean contains(String name) {
    return getList().stream().filter(prop -> Objects.equals(name, prop.getName())).findFirst()
        .isPresent();
  }

}
