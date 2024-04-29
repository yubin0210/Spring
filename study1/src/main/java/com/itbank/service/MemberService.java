package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	
	public int add(MemberDTO dto) {
		return dao.insert(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		return dao.login(dto);
	}

	public List<MemberDTO> selectList() {
		return dao.selectList();
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public MemberDTO view(int idx) {
		return dao.selectOne(idx);
	}

	public int modify(MemberDTO dto) {
		return dao.modify(dto);
	}

}
