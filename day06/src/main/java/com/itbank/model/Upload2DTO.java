package com.itbank.model;

import java.sql.Date;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

// 	TABLE : UPLOAD2
//	IDX              NOT NULL NUMBER(38)    
//	MEMO             NOT NULL VARCHAR2(100) 
//	ORIGINALFILENAME NOT NULL VARCHAR2(500) 
//	STOREDFILENAME   NOT NULL VARCHAR2(500) 
//	UPLOADDATE                DATE          

public class Upload2DTO {

	private int idx;
	private String memo;
	private String originalFileName;
	private String storedFileName;
	private Date uploadDate;
	
	private List<MultipartFile> upload;

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

	public List<MultipartFile> getUpload() {
		return upload;
	}

	public void setUpload(List<MultipartFile> upload) {
		this.upload = upload;
	}
	
	
}
