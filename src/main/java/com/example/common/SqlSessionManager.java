package com.example.common;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

@Component
public class SqlSessionManager {
  ThreadLocal<Map<String, SqlSession>> sessionMap = new ThreadLocal<>();

  public SqlSessionManager() {
    init();
  }

  /**
   * put SqlSession.
   * 
   * @param key key
   * @param session SqlSession
   */
  public void put(String key, SqlSession session) {
    init();
    if (Objects.isNull(this.sessionMap.get())) {
      this.sessionMap.set(new HashMap<String, SqlSession>());
    }
    this.sessionMap.get().put(key, session);
  }

  /**
   * get SqlSession by key.
   * 
   * @param key key
   * @return
   */
  public SqlSession get(String key) {
    init();
    return this.sessionMap.get().get(key);

  }

  /**
   * close all session.
   */
  public void close() {
    init();
    this.sessionMap.get().forEach((key, session) -> session.close());
    this.sessionMap.set(null);
  }

  private void init() {
    if (Objects.isNull(this.sessionMap.get())) {
      this.sessionMap.set(new HashMap<String, SqlSession>());
    }
  }

}
