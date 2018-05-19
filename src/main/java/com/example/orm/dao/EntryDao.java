package com.example.orm.dao;

import com.example.orm.one.dto.EntryDto;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface EntryDao {

  @Select("SELECT * FROM entry")
  public List<EntryDto> getAll();

  @Insert("INSERT INTO entry VALUES ( #{dto.id}, #{dto.value})")
  public int insert(@Param("dto") EntryDto dto);

}
