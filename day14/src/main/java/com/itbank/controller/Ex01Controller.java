package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.itbank.component.MailComponent;

@Controller
public class Ex01Controller {
	
	@Autowired private MailComponent mailComponent;

	@GetMapping("/ex01")
	public void ex01() {}
	
	@PostMapping("/ex01")
	public String ex01(String address, String subject, String content) {
		System.out.println("address : " + address);
		System.out.println("subject : " + subject);
		System.out.println("content : " + content);
		int row = mailComponent.sendSimpleMessage(address, subject, content);
		System.out.println(row != 0 ? "성공" : "실패");
		return "redirect:/";
	}
}
