package com.itbank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.service.Ex01Service;
import com.itbank.utils.Exp;

@Controller
@RequestMapping("/ex01")
public class Ex01Controller {
	
	@Autowired private Ex01Service service;

	@GetMapping
	public void ex01() {}
	
	@PostMapping
	public ModelAndView ex01(int n1, String operator, int n2) {
		ModelAndView mav = new ModelAndView("ex01-result");
		int answer = service.calc(n1, operator, n2);
		mav.addObject("n1", n1);
		mav.addObject("n2", n2);
		mav.addObject("operator", Exp.valueOf(operator).getOperator());
		mav.addObject("answer", answer);
		return mav;
	}
	
	// 3) 컨트롤러에서 발생하는 예외를 처리하기 위한 함수, 예외 유형을 클래스 형식으로 전달해야 한다
	// 필요하다면 매개변수에 예외 객체를 받을 수도 있다
	@ExceptionHandler(ArithmeticException.class)
	public ModelAndView divideByZero(ArithmeticException e) {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("e", e.getMessage());
		mav.addObject("url", "/");
		mav.addObject("msg", "값을 0으로 나눌 수 없습니다");
		return mav;
	}
	
	
	
}
