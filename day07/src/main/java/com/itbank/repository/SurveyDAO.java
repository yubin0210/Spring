package com.itbank.repository;

import java.util.List;

import com.itbank.model.ChoiceDTO;
import com.itbank.model.SurveyDTO;

public interface SurveyDAO {

	int insert(SurveyDTO dto);

	List<SurveyDTO> selectList();

	SurveyDTO selectOne(int idx);

	int insertChoice(ChoiceDTO dto);

	SurveyDTO selectResult(int idx);

}
