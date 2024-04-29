package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.repository.McDonaldDAO;

enum McDonaldCategory {
	all(null),
	burger("버거"),
	drink("음료");
	
	private String columnValue;
	
	McDonaldCategory(String columnValue) {
		this.columnValue = columnValue;
	}
	public String getColumnName() {
		return columnValue;
	}
}

@Service
public class McDonaldService {

	@Autowired private McDonaldDAO dao;

	public List<McdonaldDTO> getList(String category) {
		String columnValue = null;
//		switch(category) {
//		case "all":		columnValue = null;  	break;
//		case "burger":	columnValue = "버거";  	break;
//		case "drink":	columnValue = "음료";  	break;
//		}
		
		McDonaldCategory e1 = McDonaldCategory.valueOf(category);
		columnValue = e1.getColumnName();
		
		System.out.println("category : " + category);
		System.out.println("columnValue : " + columnValue);
		System.out.println();
		return dao.selectList(columnValue);
	}

	public McdonaldDTO selectOne(int idx) {
		return dao.selectOne(idx);
	}
}










