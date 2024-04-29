package com.itbank.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView mav = new ModelAndView("home");
		Date date = null;	
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일");
//		try {
			String today = sdf.format(date);
			mav.addObject("today", today);
//		} catch(NullPointerException e) {
//			System.out.println("예외가 발생했습니다 : " + e);
//		}
		return mav;
	}
	
	@ExceptionHandler(NullPointerException.class)	// 지정한 클래스타입의 예외가 현재 컨트롤러에서 발생하면
	public ModelAndView npe() {						// 아래 함수를 실행한다 (try ~ catch 의 함수화)
		ModelAndView mav = new ModelAndView("home");// 응답을 전달하는 방식은 @RequestMapping과 유사하다
		mav.addObject("today", new Date());			
		return mav;
	}	
	// 현재 컨트롤러 및 컨트롤러 하위의 Service, DAO, Component 에서 발생하는 예외를 모두 처리한다
	// 하위 스프링 빈이 예외를 throws 해야 한다
}




