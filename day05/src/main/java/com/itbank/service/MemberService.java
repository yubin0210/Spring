package com.itbank.service;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {

	@Autowired private MemberDAO dao;
	@Autowired private HashComponent hashComponent;
	
	public List<MemberDTO> getMemberList() {
		List<MemberDTO> list = dao.selectList();
		list.forEach(dto -> dto.setUserpw("********"));
		return list;
	}

	public MemberDTO getMember(int idx) {
		return dao.selectOne(idx);
	}

	public int add(MemberDTO dto) {
		String hash = hashComponent.getHash(dto.getUserpw());
		dto.setUserpw(hash);
		return dao.insert(dto);
	}

	public MemberDTO login(MemberDTO dto) {
		// 사용자가 입력한 패스워드로 해시값을 생성한다
		String hash = hashComponent.getHash(dto.getUserpw());
		
		// 만들어진 해시값을 이용하여 DB에 저장된 해시값과 비교한다
		dto.setUserpw(hash);
		return dao.login(dto);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public int modify(MemberDTO dto) {
		String hash = hashComponent.getHash(dto.getUserpw());
		dto.setUserpw(hash);
		int row = dao.update(dto);
		return row;
	}

	public String resetPass(MemberDTO dto) {
		String newPassword = UUID.randomUUID().toString().replace("-", "").substring(0, 8);
		String hash = hashComponent.getHash(newPassword);
		
		System.out.println("newPassword : " + newPassword);
		System.out.println("hash : " + hash);
		
		dto.setUserpw(hash);
		int row = dao.updatePassword(dto);
		return row != 0 ? newPassword : null;
	}

}









