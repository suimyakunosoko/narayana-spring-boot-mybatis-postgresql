package com.example.orm.one.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.orm.one.dto.EntryDto;

public interface EntryOneDao {

	@Select("SELECT * FROM entry")
	public List<EntryDto> getAll();

	@Insert("INSERT INTO entry VALUES ( #{dto.id}, #{dto.value})")
	public int insert(@Param("dto")EntryDto dto);

}
