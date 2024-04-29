package com.itbank.controller;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ex02")
public class Ex02Controller {
	
	@GetMapping
	public void ex02() {}
	
	@PostMapping
	public String ex02(MultipartFile upload, RedirectAttributes rttr) 
			throws IllegalStateException, IOException {	
		// <input type="file" name="upload">
		// multipartRequest를 일일히 매개변수에 받지 않고, 
		// String 파라미터를 매개변수를 통해 전달받는것과 같이
		// 파일도 매개변수를 통해 전달받을 수 있다
		
		// 리다이렉트 시 mav.addObject 를 수행하면 쿼리스트링으로 주소창에 노출이되지만
		// RedirectAttributes 는 Model을 extends 하는 클래스이며
		// 세션에 잠시 저장해두었다가, Model로 이동시키는 역할을 수행한다
		// 따라서, 값도 전달할 수 있으면서, 주소창에 노출시키지도 않는다
		rttr.addFlashAttribute("fileName", upload.getOriginalFilename());
		rttr.addFlashAttribute("fileSize", upload.getSize());
		File f = new File("C:\\upload", upload.getOriginalFilename());
		upload.transferTo(f);	// 사용자가 전송한 upload를 지정한 위치의 파일 f로 전송한다
		return "redirect:/ex02";
	}

}





