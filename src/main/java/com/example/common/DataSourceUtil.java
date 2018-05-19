package com.example.common;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;
import javax.sql.DataSource;
import javax.sql.XADataSource;
import org.springframework.boot.jta.narayana.NarayanaDataSourceBean;

public class DataSourceUtil {

  /**
   * crate DataSource by BaseDataSource.
   * 
   * @param baseDatasource baseDatasource
   * @return
   */
  public static DataSource getDataSource(MyDataSource baseDatasource) {
    XADataSource xaDataSource = getXaDataSource(baseDatasource);
    NarayanaDataSourceBean dataSource = new NarayanaDataSourceBean(xaDataSource);
    return dataSource;
  }

  /**
   * crate XADataSource by BaseDataSource.
   * 
   * @param baseDatasource baseDatasource
   * @return
   */
  public static MyXaDataSource getXaDataSource(MyDataSource baseDatasource) {
    MyXaDataSource datasource = new MyXaDataSource();

    return DataSourceUtil.fillNullByDefault(baseDatasource, datasource, MyXaDataSource.class);
  }

  /**
   * Fill null field by default value.
   * 
   * @param target Target instance
   * @param def Default instance
   * @return Filled instance
   */
  @SuppressWarnings("unchecked")
  public static <T> T fillNullByDefault(T target, T def) {
    if (Objects.isNull(target)) {
      return null;
    }
    return (T) fillNullByDefault(target, def, target.getClass());
  }

  /**
   * Fill null field by default value.
   * 
   * @param target Target instance
   * @param def Default instance
   * @return Filled instance
   */
  public static <T> T fillNullByDefault(Object target, Object def, Class<T> clazz) {
    if (Objects.isNull(target) && Objects.isNull(def)) {
      return null;
    } else if (Objects.isNull(target)) {
      target = def;
    } else if (Objects.isNull(def)) {
      def = target;
    }
    try {
      T rtn = clazz.newInstance();
      Method[] setter = getSetter(clazz);
      for (Method method : setter) {
        String setterName = method.getName();
        String getterName = "get";
        if (setterName.length() > 4) {
          getterName = getterName + setterName.substring(3);
        }
        Method getter;
        try {
          getter = clazz.getMethod(getterName);
        } catch (NoSuchMethodException e) {
          // no getter, do nothing
          continue;
        }
        Object targetValue = getter.invoke(target);
        Object defValue = getter.invoke(def);
        Class<?> returnType = getter.getReturnType();
        if (returnType.isArray() || returnType.isAssignableFrom(Collection.class)) {
          // if collection copy items
          method.invoke(rtn, fillNullByDefault(targetValue, defValue));
          continue;
        } else if (getSetter(returnType).length > 0) {
          method.invoke(rtn, fillNullByDefault(targetValue, defValue));
          continue;
        } else {
          Object value = Objects.isNull(targetValue) ? defValue : targetValue;
          method.invoke(rtn, value);
        }
      }
      return rtn;
    } catch (InstantiationException | IllegalAccessException | IllegalArgumentException
        | InvocationTargetException | SecurityException e) {
      // do nothing.
      throw new RuntimeException(e);
    }
  }

  private static Method[] getSetter(Class<?> clazz) {
    return Arrays.stream(clazz.getMethods()).filter(method -> method.getName().startsWith("set"))
        .toArray(Method[]::new);
  }

  /**
   * Check contains null object.
   * 
   * @param objects object array
   * @return Return true when contains null object
   */
  public static boolean containsNull(Object... objects) {
    if (Objects.isNull(objects)) {
      return true;
    }
    return Arrays.stream(objects).anyMatch(Objects::isNull);
  }

}
