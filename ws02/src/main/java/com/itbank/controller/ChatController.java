package com.itbank.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.itbank.model.RoomDTO;
import com.itbank.repository.ChatRoomRepository;

@Controller
@RequestMapping("/chat")
public class ChatController {
	
	@Autowired
	private ChatRoomRepository repository;

	@GetMapping("/rooms")
	public ModelAndView rooms(String username, HttpSession session) {
		ModelAndView mav = new ModelAndView();
		if(username != null) {
			session.setAttribute("username", username);
			session.setMaxInactiveInterval(600);
		}
		List<RoomDTO> list = repository.findAllRooms();
		System.out.println("=== 현재 개설된 방 목록 ===");
		list.forEach(System.out::println);
		System.out.println("========================\n");
		mav.addObject("list", list);
		return mav;
	}
	
	@PostMapping("/rooms")
	public String create(String name, RedirectAttributes rttr) {
		RoomDTO room = repository.createChatRoom(name);
		rttr.addFlashAttribute("roomName", room.getName());
		return "redirect:/chat/rooms";	// -> @GetMapping("/rooms")
	}
	
	@GetMapping("/room")
	public ModelAndView getRoom(String roomId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("room", repository.findRoomById(roomId));
		return mav;
	}
}







