package com.itbank.repository;

import java.sql.Date;

import org.apache.ibatis.annotations.Select;

public interface Test3DAO {
	
	// private SqlSessionTemplate sst;

	// sqlSessionTemplate을 직접 참조할때와 같이 xml mapper를 사용하는 방법
	// namespace: package + Interface Name (com.itbank.repository.Test3DAO)
	// id: 함수 이름 (selectBanner)
	String selectBanner(); // {
	//		return sst.selectOne("com.itbank.repository.Test3DAO.selectBanner");
	// }
	

	// 간단한 sql은 어노테이션으로 처리하여 mapper도 생략할 수 있다
	@Select("select sysdate from dual")
	Date selectSysdate();

}
