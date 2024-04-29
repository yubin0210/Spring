package com.itbank.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.itbank.component.MailComponent;

@Controller
public class Ex02Controller {
	
	@Autowired private MailComponent mailComponent;

	@GetMapping("/ex02")
	public void ex02() {}
	
	@PostMapping("/ex02")
	public String ex02(@RequestParam HashMap<String, String> param) {
		int row = mailComponent.sendMimeMessage(param);
		System.out.println(row != 0 ? "성공" : "실패");
		return "redirect:/";
	}
}
