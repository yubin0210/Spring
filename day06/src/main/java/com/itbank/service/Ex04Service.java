package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.itbank.component.FileComponent;
import com.itbank.model.Upload2DTO;
import com.itbank.repository.Ex04DAO;

@Service
public class Ex04Service {

	@Autowired private FileComponent fc;
	@Autowired private Ex04DAO dao;

	public int uploadMultiple(Upload2DTO dto) {
		int row = 0;
		List<MultipartFile> list = dto.getUpload();
		String ori = "";
		String result = "";
		for(MultipartFile f : list) {
			ori += f.getOriginalFilename() + ":";
			result += fc.upload(f) + ":";
		}
		ori = ori.substring(0, ori.length() - 1);
		result = result.substring(0, result.length() - 1);
		dto.setOriginalFileName(ori);
		dto.setStoredFileName(result);
		row = dao.insertMultiple(dto);
		return row;
	}

	public List<Upload2DTO> getList() {
		return dao.selectList();
	}
	
	
}
