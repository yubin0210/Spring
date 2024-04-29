package com.itbank.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = dao.selectList();
		list.forEach(dto -> dto.setUserpw("********"));
		return list;
	}

	public MemberDTO getMember(int idx) {
		return dao.selectOne(idx);
	}

	public int add(MemberDTO dto) {
		return dao.insert(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		return dao.login(dto);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public int modify(MemberDTO dto) {
		int row = dao.update(dto);
		return row;
	}

	public String resetPass(MemberDTO dto) {
		String newPassword = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		
		String t1 = UUID.randomUUID().toString();
		System.out.println(t1);
		System.out.println(t1.replace("-", ""));
		System.out.println(t1.replace("-", "").substring(0, 8));
		System.out.println();
		
		dto.setUserpw(newPassword);
		int row = dao.updatePassword(dto);
		return row != 0 ? newPassword : null;
	}

}









