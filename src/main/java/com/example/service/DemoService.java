package com.example.service;

import com.example.common.SqlSessionUtil;
import com.example.orm.dao.EntryDao;
import com.example.orm.one.dao.EntryOneDao;
import com.example.orm.one.dto.EntryDto;
import com.example.orm.two.dao.EntryTwoDao;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class DemoService {

  @Autowired
  private EntryOneDao entryOneDao;

  @Autowired
  private EntryTwoDao entryTwoDao;

  @Autowired
  SqlSessionUtil sessionUtil;

  public int demonstrateCommit(String entry) throws Exception {
    return executeDemonstration(entry);
  }

  public int demonstrateCommitP(String entry) throws Exception {
    return executeDemonstrationP(entry);
  }

  public void demonstrateRollback(String entry) throws Exception {
    executeDemonstration(entry);
    throw new RuntimeException("will Rollback");
  }

  public void demonstrateRollbackP(String entry) throws Exception {
    executeDemonstrationP(entry);
    throw new RuntimeException("will Rollback");
  }


  private int executeDemonstration(String entry) throws Exception {
    List<EntryDto> dtoList = this.entryOneDao.getAll();
    System.out.println("Entries at the start: " + dtoList);
    System.out.println("Entries at the start: " + this.entryTwoDao.getAll());

    EntryDto dto = new EntryDto();
    dto.setId(dtoList.size());
    dto.setValue(entry + ": " + String.valueOf(System.nanoTime()));
    int ret = this.entryOneDao.insert(dto);
    this.entryTwoDao.insert(dto);

    System.out.println("Entries at the end: " + this.entryOneDao.getAll());
    return ret;
  }

  private int executeDemonstrationP(String entry) throws Exception {
    transactionalSection(entry, new String[] {"One", "Two", "Three"});
    return 0;
  }

  private void transactionalSection(String entry, String[] databaseList) {
    Arrays.stream(databaseList).forEach(database -> {
      EntryDao entryDao =
          this.sessionUtil.getSqlSession(database, "datasource").getMapper(EntryDao.class);
      List<EntryDto> dtoList = entryDao.getAll();
      System.out.println("Entries at the start: " + dtoList);
      EntryDto dto = new EntryDto();
      dto.setId(dtoList.stream().max((a, b) -> a.getId() - b.getId()).get().getId() + 1);
      dto.setValue(entry + ": " + String.valueOf(System.nanoTime()));
      entryDao.insert(dto);
      entryDao.getAll();
      System.out.println("Entries at the end: " + entryDao.getAll());
    });
  }

}
