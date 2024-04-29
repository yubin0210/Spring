package com.itbank.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.member.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;

	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = dao.selectList();
		list.forEach(dto -> dto.setUserpw("******"));
		return list;
	}

	public List<MemberDTO> getMemberSearchList(HashMap<String, String> paramMap) {
		// 마이바티스의 함수에는 인자를 하나만 전달하거나, 전달하지 않는다
		List<MemberDTO> list = dao.selectSearchList(paramMap);
		list.forEach(dto -> dto.setUserpw("******"));
		return list;
	}

	public int add(MemberDTO dto) {
		int row = dao.insert(dto);
		return row;
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}
}



