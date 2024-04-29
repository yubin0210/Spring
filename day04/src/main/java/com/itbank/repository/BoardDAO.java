package com.itbank.repository;

import java.util.List;

import com.itbank.model.BoardDTO;

public interface BoardDAO {

	List<BoardDTO> selectList();

	BoardDTO selectOne(int idx);

	int insert(BoardDTO dto);

	int delete(int idx);

}
















