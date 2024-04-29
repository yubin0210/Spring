package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.ProductDTO;
import com.itbank.service.productService;

@Controller
@RequestMapping("/product")
public class ProductController {

	@Autowired private productService service;
	
	@GetMapping("/insert")
	public void insert() {}
	
	@PostMapping("/insert")
	public String insert(ProductDTO dto) {
		int row = service.insert(dto);
		System.out.println(row != 0 ? "추가 성공" : "추가 실패");
		return "redirect:/product/list";
	}
	
	@GetMapping("/list")
	public ModelAndView proList() {
		ModelAndView mav = new ModelAndView();
		List<ProductDTO> list = service.selectList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView show(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/product/view");
		ProductDTO dto = service.show(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/product/update+/{idx}")
	public String updatePlus(@PathVariable("idx") int idx) {
		
		return "redirect:/product/view/{idx}";
	}
	
	
	
	
	
	
	
	
	
	
	
	
}
