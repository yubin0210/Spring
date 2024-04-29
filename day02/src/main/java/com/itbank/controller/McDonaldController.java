package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.mcdonald.McdonaldDTO;
import com.itbank.service.McDonaldService;



@Controller
public class McDonaldController {

	@Autowired private McDonaldService mcDonaldService;
	
	@GetMapping("/list/{category}")
	public ModelAndView list(@PathVariable("category") String category) {
		ModelAndView mav = new ModelAndView("list");
		List<McdonaldDTO> list = mcDonaldService.getList(category);
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("view");
		McdonaldDTO dto = mcDonaldService.selectOne(idx);
		mav.addObject("dto", dto);
		return mav;
	}
}



