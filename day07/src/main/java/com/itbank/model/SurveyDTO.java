package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

// 	TABLE : SURVEY
//	IDX     NOT NULL NUMBER        
//	TITLE   NOT NULL VARCHAR2(500) 
//	WRITER           VARCHAR2(500) 
//	OPTION1 NOT NULL VARCHAR2(500) 
//	OPTION2 NOT NULL VARCHAR2(500) 
//	IMAGE1  NOT NULL VARCHAR2(500) 
//	IMAGE2  NOT NULL VARCHAR2(500) 

public class SurveyDTO {

	private int idx;
	private String title;
	private String writer;
	private String option1;
	private String option2;
	private String image1;
	private String image2;
	
	private MultipartFile upload1;
	private MultipartFile upload2;
	
	private int responseCount;	// 설문에 참여한 인원의 수
	private int choice1Count;
	private int choice2Count;
	private double choice1Rate;
	private double choice2Rate;
	
	public double getChoice1Rate() {
		return choice1Rate;
	}
	public void setChoice1Rate(double choice1Rate) {
		this.choice1Rate = choice1Rate;
	}
	public double getChoice2Rate() {
		return choice2Rate;
	}
	public void setChoice2Rate(double choice2Rate) {
		this.choice2Rate = choice2Rate;
	}
	public int getChoice1Count() {
		return choice1Count;
	}
	public void setChoice1Count(int choice1Count) {
		this.choice1Count = choice1Count;
	}
	public int getChoice2Count() {
		return choice2Count;
	}
	public void setChoice2Count(int choice2Count) {
		this.choice2Count = choice2Count;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getOption1() {
		return option1;
	}
	public void setOption1(String option1) {
		this.option1 = option1;
	}
	public String getOption2() {
		return option2;
	}
	public void setOption2(String option2) {
		this.option2 = option2;
	}
	public String getImage1() {
		return image1;
	}
	public void setImage1(String image1) {
		this.image1 = image1;
	}
	public String getImage2() {
		return image2;
	}
	public void setImage2(String image2) {
		this.image2 = image2;
	}
	public MultipartFile getUpload1() {
		return upload1;
	}
	public void setUpload1(MultipartFile upload1) {
		this.upload1 = upload1;
	}
	public MultipartFile getUpload2() {
		return upload2;
	}
	public void setUpload2(MultipartFile upload2) {
		this.upload2 = upload2;
	}
	public int getResponseCount() {
		return responseCount;
	}
	public void setResponseCount(int responseCount) {
		this.responseCount = responseCount;
	}
	
	
}
