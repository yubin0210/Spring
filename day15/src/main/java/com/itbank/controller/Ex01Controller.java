package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class Ex01Controller {

	private final String saveDirectory = "C:\\upload";
	
	@PostMapping("/ajax/ex01")
	public String ex01Upload(MultipartFile upload) throws IllegalStateException, IOException  {
		System.out.println(upload);
		File f = new File(saveDirectory, upload.getOriginalFilename());
		upload.transferTo(f);
		return upload.getOriginalFilename();
	}
}
