package com.itbank.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.component.FileComponent;
import com.itbank.model.ProductDTO;
import com.itbank.repository.productDAO;

@Service
public class productService {

	@Autowired private productDAO dao;
	@Autowired private FileComponent fileComponent;
	
	public int insert(ProductDTO dto) {
		String image = fileComponent.upload(dto.getUpload());
		dto.setImage(image);
		return dao.insert(dto);
	}

	public List<ProductDTO> selectList() {
		return dao.selectList();
	}

	public ProductDTO show(int idx) {
		return dao.selectOne(idx);
	}

}
