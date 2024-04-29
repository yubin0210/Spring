package com.itbank.model;

//	TABLE : CHOICE
//	IDX        NOT NULL NUMBER        
//	WRITER              VARCHAR2(500) 
//	SURVEY_IDX          NUMBER        
//	CHOICE              NUMBER   

public class ChoiceDTO {
	
	private int idx;
	private String writer;
	private int survey_idx;
	private int choice;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public int getSurvey_idx() {
		return survey_idx;
	}
	public void setSurvey_idx(int survey_idx) {
		this.survey_idx = survey_idx;
	}
	public int getChoice() {
		return choice;
	}
	public void setChoice(int choice) {
		this.choice = choice;
	}
	
	

}
