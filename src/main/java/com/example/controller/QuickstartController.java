package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.service.DemoService;

@Controller
public class QuickstartController {
	
	@Autowired
	private DemoService service;
	
	@ResponseBody
	@RequestMapping("insert")
	public int insert() throws Exception {
		return service.demonstrateCommit("insert");
	}
	

	@ResponseBody
	@RequestMapping("rollback")
	public int rollback() throws Exception {
		service.demonstrateRollback("rollback");
		return -1;
	}
	
	@ResponseBody
	@RequestMapping("insertP")
	public int insertP() throws Exception {
		return service.demonstrateCommitP("insertP");
	}
	

	@ResponseBody
	@RequestMapping("rollbackP")
	public int rollbackP() throws Exception {
		service.demonstrateRollbackP("rollbackP");
		return -1;
	}

}
