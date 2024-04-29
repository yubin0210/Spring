package com.itbank.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.itbank.model.BoardDTO;
import com.itbank.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired private BoardService boardService;

	@GetMapping("/list")
	public ModelAndView list() {
		ModelAndView mav = new ModelAndView();
		List<BoardDTO> list = boardService.getBoardList();
		mav.addObject("list", list);
		return mav;
	}
	
	@GetMapping("/view/{idx}")
	public ModelAndView view(@PathVariable("idx") int idx) {
		ModelAndView mav = new ModelAndView("/board/view");
		BoardDTO dto = boardService.getBoard(idx);
		mav.addObject("dto", dto);
		return mav;
	}
	
	@GetMapping("/write")
	public void write() {}
	
	@PostMapping("/write")
	public String write(BoardDTO dto) {
		int row = boardService.write(dto);
		System.out.println(row != 0 ? "작성 성공" : "작성 실패");
		return "redirect:/board/list";
	}
	
	@GetMapping("/delete/{idx}")
	public ModelAndView delete(@PathVariable("idx") int idx) {
		// if(session.getAttribute("login") == null) {
		//		return "redirect:/member/login";
		// }
		// 컨트롤러에 들어오는 요청을 가로채서 특정 작업(예를 들어 로그인 여부 파악)을 수행하고
		// 기존 경로로 계속 안내하거나, 처리를 중단하고 새로운 응답을 반환하는 스프링 빈이 필요하다
		
		ModelAndView mav = new ModelAndView("alert");
		int row = boardService.delete(idx);
		String url = "/board/list";
		String msg = row != 0 ? "삭제 성공" : "삭제 실패";
		mav.addObject("url", url);
		mav.addObject("msg", msg);
		return mav;
	}
}






