package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.BoardDTO;
import com.itbank.repository.BoardDAO;

@Service
public class BoardService {

	@Autowired private BoardDAO dao;
	
	public List<BoardDTO> getBoardList() {
		return dao.selectList();
	}

	public BoardDTO getBoard(int idx) {
		return dao.selectOne(idx);
	}

	public int write(BoardDTO dto) {
		return dao.insert(dto);
	}

	public int delete(int idx) {
		return dao.delete(idx);
	}

	public int modify(BoardDTO dto) {
		return dao.update(dto);
	}

}












