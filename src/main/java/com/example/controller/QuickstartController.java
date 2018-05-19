package com.example.controller;

import com.example.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuickstartController {

  @Autowired
  private DemoService service;

  @ResponseBody
  @RequestMapping("insert")
  public int insert() throws Exception {
    return this.service.demonstrateCommit("insert");
  }


  @ResponseBody
  @RequestMapping("rollback")
  public int rollback() throws Exception {
    this.service.demonstrateRollback("rollback");
    return -1;
  }

  @ResponseBody
  @RequestMapping("insertP")
  public int insertP() throws Exception {
    return this.service.demonstrateCommitP("insertP");
  }


  @ResponseBody
  @RequestMapping("rollbackP")
  public int rollbackP() throws Exception {
    this.service.demonstrateRollbackP("rollbackP");
    return -1;
  }

  @ResponseBody
  @PostMapping("upload")
  public int upload(@RequestBody(required = false) Object fileName) throws Exception {
    System.out.println(fileName);
    return 0;
  }

}
