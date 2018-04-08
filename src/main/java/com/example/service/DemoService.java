package com.example.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.datasource.SqlSessionUtil;
import com.example.orm.dao.EntryDao;
import com.example.orm.one.dao.EntryOneDao;
import com.example.orm.one.dto.EntryDto;
import com.example.orm.two.dao.EntryTwoDao;

@Service
@Transactional
public class DemoService {

	@Autowired
	private EntryOneDao entryOneDao;

	@Autowired
	private EntryTwoDao entryTwoDao;

	@Autowired
	SqlSessionUtil sessionUtil;

//	@Transactional
	public int demonstrateCommit(String entry) throws Exception {
		return executeDemonstration(entry);
	}

	public int demonstrateCommitP(String entry) throws Exception {
		return executeDemonstrationP(entry);
	}

//	@Transactional
	public void demonstrateRollback(String entry) throws Exception {
		executeDemonstration(entry);
		throw new RuntimeException("will Rollback");
	}

	public void demonstrateRollbackP(String entry) throws Exception {
		executeDemonstrationP(entry);
		throw new RuntimeException("will Rollback");
	}


	private int executeDemonstration(String entry) throws Exception {
		List<EntryDto> dtoList = entryOneDao.getAll();
		System.out.println("Entries at the start: " + dtoList);
		System.out.println("Entries at the start: " + entryTwoDao.getAll());

		EntryDto dto = new EntryDto();
		dto.setId(dtoList.size());
		dto.setValue(entry + ": " + String.valueOf(System.nanoTime()));
		int ret = entryOneDao.insert(dto);
		entryTwoDao.insert(dto);

		System.out.println("Entries at the end: " + entryOneDao.getAll());
		return ret;
	}

	private int executeDemonstrationP(String entry) throws Exception {
		SqlSessionFactory factoryOne = sessionUtil.getSqlSessionFactory("datasource", "One");
		SqlSessionFactory factoryTwo = sessionUtil.getSqlSessionFactory("datasource", "Two");
		SqlSessionFactory factoryThree = sessionUtil.getSqlSessionFactory("datasource", "Three");
		try(SqlSession sessionOne = factoryOne.openSession();
				SqlSession sessionTwo = factoryTwo.openSession();
				SqlSession sessionThree = factoryThree.openSession();) {
//			SqlSession sessionOne = factoryOne.openSession();
//			SqlSession sessionTwo = factoryTwo.openSession();
//			SqlSession sessionThree = factoryThree.openSession();    	
			TransactionalSection(entry, sessionOne, sessionTwo, sessionThree);
			return 0;
		}
		
		//TODO: org.apache.ibatis.executor.BaseExecutor  : Unexpected exception on closing transaction.  
		//      Cause: java.sql.SQLException: Commit can not be set while enrolled in a transaction
	}

//	@Transactional
	private void TransactionalSection(String entry, SqlSession sessionOne, SqlSession sessionTwo, SqlSession sessionThree) {
		EntryDao entryOneDaoP = sessionOne.getMapper(EntryDao.class);
		EntryDao entryTwoDaoP = sessionTwo.getMapper(EntryDao.class);
		EntryDao entryThreeDaoP = sessionThree.getMapper(EntryDao.class);
		List<EntryDto> dtoList = entryOneDaoP.getAll();
		System.out.println("Entries at the start: " + dtoList);
		System.out.println("Entries at the start: " + entryTwoDaoP.getAll());

		EntryDto dto = new EntryDto();
		dto.setId(dtoList.size());
		dto.setValue(entry + ": " + String.valueOf(System.nanoTime()));
		entryOneDaoP.insert(dto);
		entryTwoDaoP.insert(dto);
//		entryThreeDaoP.insert(dto);
		entryThreeDaoP.getAll();

		System.out.println("Entries at the end: " + entryOneDaoP.getAll());

	}

}
