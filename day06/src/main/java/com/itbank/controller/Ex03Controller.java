package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itbank.model.Upload1DTO;
import com.itbank.service.UploadService;

@Controller
@RequestMapping("/ex03")
public class Ex03Controller {
	
	@Autowired private UploadService service;
	
	// GET, POST 메서드를 구분하고 싶다면 <view-controller> 태그를 쓸 수 없다
	@GetMapping
	public ModelAndView ex03() {
		ModelAndView mav = new ModelAndView();
		List<Upload1DTO> list = service.getList();
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping
	public String ex03(Upload1DTO dto) {
		int row = service.upload(dto);
		System.out.println(row != 0 ? "등록 성공" : "등록 실패");
		return "redirect:/ex03";
	}
	
	@GetMapping("/delete/{idx}")
	public String delete(@PathVariable("idx") int idx, RedirectAttributes rttr) {
		int row = service.delete(idx);
		rttr.addFlashAttribute("msg", row != 0 ? "삭제 성공" : "삭제 실패");
		return "redirect:/ex03";
	}
}







