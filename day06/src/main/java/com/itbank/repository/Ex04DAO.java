package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.Upload2DTO;

public interface Ex04DAO {

	@Insert("insert into upload2 (memo, originalFileName, storedFileName) "
			+ "	values (#{memo}, #{originalFileName}, #{storedFileName})")
	int insertMultiple(Upload2DTO dto);

	@Select("select * from upload2 order by idx")
	List<Upload2DTO> selectList();

}
