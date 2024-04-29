package com.itbank.repository;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.itbank.model.ScheduleDTO;

@Repository
public interface ScheduleDAO {

	@Select("select * from schedule order by sDate")
	List<ScheduleDTO> selectList();

	@Insert("insert into schedule (sDate, memo) values (#{sDate}, #{memo})")
	int insert(ScheduleDTO dto);

	@Delete("delete schedule where idx = #{idx}")
	int delete(int idx);

}
