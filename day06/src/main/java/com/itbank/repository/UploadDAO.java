package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import com.itbank.model.Upload1DTO;

public interface UploadDAO {

	@Insert("insert into upload1 (memo, originalFileName, storedFileName) "
			+ "	values (#{memo}, #{originalFileName}, #{storedFileName})")
	int insert(Upload1DTO dto);

	@Select("select * from upload1 order by idx")
	List<Upload1DTO> selectList();

	@Select("select * from upload1 where idx = #{idx}")
	Upload1DTO selectOne(int idx);

	@Delete("delete upload1 where idx = #{idx}")
	int delete(int idx);

}
