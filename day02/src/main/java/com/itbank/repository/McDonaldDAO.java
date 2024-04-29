package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import com.itbank.mcdonald.McdonaldDTO;

public interface McDonaldDAO {

	@Select("<script>"
			+ "select * from mcdonald "
			+ " <if test=\"category != null\">"
			+ "		where category = #{category}"
			+ " </if>"
			+ " order by idx"
			+ "</script>")
	List<McdonaldDTO> selectList(String category);

	@Select("select * from mcdonald where idx = #{idx}")
	McdonaldDTO selectOne(int idx);

}






