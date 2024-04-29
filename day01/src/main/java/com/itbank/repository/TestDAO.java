package com.itbank.repository;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository
public class TestDAO {
	
	@Autowired private JdbcTemplate jdbcTemplate;

	public String selectBanner() {
		String sql = "select banner from v$version";
		
//		RowMapper<String> rowMapper = new RowMapper<String>() {
//			@Override
//			public String mapRow(ResultSet rs, int rowNum) throws SQLException {
//				return rs.getString("banner");
//			}
//		};
		
		RowMapper<String> rowMapper = (rs, rownum) -> rs.getString("banner");
		
		String version = jdbcTemplate.queryForObject(sql, rowMapper);
		return version;
	}

	public Date selectSysdate() {
		String sql = "select sysdate from dual";
		
//		Date sysdate = jdbcTemplate.queryForObject(sql, Date.class);
		
		Date sysdate = jdbcTemplate.queryForObject(sql, (rs, num) -> rs.getDate("sysdate"));
		
		return sysdate;
	}

}
