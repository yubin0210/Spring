package com.itbank.model;

import java.sql.Date;

import org.springframework.web.multipart.MultipartFile;

// 	TABLE : UPLOAD1
//	IDX              NOT NULL NUMBER(38)    
//	MEMO             NOT NULL VARCHAR2(100) 
//	ORIGINALFILENAME NOT NULL VARCHAR2(500) 
//	STOREDFILENAME   NOT NULL VARCHAR2(500) 
//	UPLOADDATE                DATE          

public class Upload1DTO {

	// 아래 5개 필드는 DB에 저장하는 컬럼과 매치됨
	private int idx;
	private String memo;
	private String originalFileName;
	private String storedFileName;
	private Date uploadDate;
	
	// 아래 1개 필드는 form태그의 file을 파라미터로 받기 위한 필드임
	// (DB에는 저장하지 않음)
	private MultipartFile upload;
	
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}
	public String getOriginalFileName() {
		return originalFileName;
	}
	public void setOriginalFileName(String originalFileName) {
		this.originalFileName = originalFileName;
	}
	public String getStoredFileName() {
		return storedFileName;
	}
	public void setStoredFileName(String storedFileName) {
		this.storedFileName = storedFileName;
	}
	public Date getUploadDate() {
		return uploadDate;
	}
	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	
	
}
