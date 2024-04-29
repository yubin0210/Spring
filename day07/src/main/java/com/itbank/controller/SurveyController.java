package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ChoiceDTO;
import com.itbank.model.SurveyDTO;
import com.itbank.service.SurveyService;

@Controller
@RequestMapping("/survey")
public class SurveyController {
	
	@Autowired private SurveyService service;
	
	// @RequestMapping (@GetMapping, @PostMapping) 함수는
	// 특정 주소, 특정 메서드로 요청을 받으면 자동으로 실행되는 이벤트 함수의 성격을 가진다
	
	// 만약, 예외가 발생하면 @ExceptionHandler 어노테이션이 붙은 함수가 자동으로 실행된다
	// 이때, 발생하는 예외의 타입에 따라 서로 다른 함수를 실행할 수 있다
	// 컨트롤러 내부에서도  ExceptionHandler 를 작성할 수 있지만
	// 컨트롤러는 본래, 요청에 따른 처리를 작성하는 클래스이므로,
	// 별도의 클래스를 만들어서 예외만 전문적으로 처리하는 스프링 빈을 작성할 수도 있다
	@ExceptionHandler(DuplicateKeyException.class)
	public ModelAndView dupKey() {
		ModelAndView mav = new ModelAndView("alert");
		mav.addObject("msg", "이미 참여한 투표입니다");
		return mav;
	}
	
	@GetMapping("/add")
	public void add() {}
	
	@PostMapping("/add")
	public String add(SurveyDTO dto) {
		int row = service.add(dto);
		System.out.println(row != 0 ? "등록 성공" : "등록 실패");
		return "redirect:/";
	}
	
	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<SurveyDTO> list = service.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/vote/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/survey/vote");
		SurveyDTO dto = service.getSurvey(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@PostMapping("/vote/{idx}")
	public String view(ChoiceDTO dto) {
		int row = service.addChoice(dto);
		System.out.println(row != 0 ? "응답 성공" : "응답 실패");
		return "redirect:/survey/result/{idx}";
	}
	
	@GetMapping("/result/{idx}")
	public ModelAndView result(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/survey/result");
		SurveyDTO dto = service.getResult(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
}
