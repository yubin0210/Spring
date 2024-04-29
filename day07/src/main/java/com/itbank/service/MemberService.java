package com.itbank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.HashComponent;
import com.itbank.model.MemberDTO;
import com.itbank.repository.MemberDAO;

@Service
public class MemberService {
	
	@Autowired private MemberDAO dao;
	@Autowired private HashComponent hashComponent;

	public MemberDTO getLogin(MemberDTO dto) {
		dto.setUserpw(hashComponent.getHash(dto.getUserpw()));
		return dao.login(dto);
	}

}
