package com.itbank.model;

import org.springframework.web.multipart.MultipartFile;

//	IDX      NOT NULL NUMBER        
//	NAME     NOT NULL VARCHAR2(500) 
//	IMAGE    NOT NULL VARCHAR2(500) 
//	PRICE    NOT NULL NUMBER        
//	QUANTITY          NUMBER   

public class ProductDTO {

	private int idx;
	private String name;
	private String image;
	private int price;
	private int quantity;
	
	private MultipartFile upload;
	
	public MultipartFile getUpload() {
		return upload;
	}
	public void setUpload(MultipartFile upload) {
		this.upload = upload;
	}
	public int getIdx() {
		return idx;
	}
	public void setIdx(int idx) {
		this.idx = idx;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
