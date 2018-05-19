package com.example.aop;

import com.example.common.SqlSessionManager;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Aspect
@Component
@Order(Ordered.LOWEST_PRECEDENCE - 1)
@Transactional
public class SessionCloseAspect {

  @Autowired
  SqlSessionManager manager;

  @After("@within(org.springframework.transaction.annotation.Transactional)")
  public void closeSqlSession() {
    this.manager.close();
  }

}
