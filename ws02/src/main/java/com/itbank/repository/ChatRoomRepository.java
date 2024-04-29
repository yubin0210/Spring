package com.itbank.repository;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.itbank.model.RoomDTO;

@Repository
public class ChatRoomRepository {

	private Map<String, RoomDTO> roomMap = new LinkedHashMap<>();
	
	public List<RoomDTO> findAllRooms() {			// 모든 방의 객체를 리스트로 반환
		List<RoomDTO> result = new ArrayList<>(roomMap.values());	// Map의 values만 추출
		Collections.reverse(result);								// 순서 뒤집기(최신방먼저)
		return result;
	}
	
	public RoomDTO findRoomById(String id) {		// 저장된 방은 각각 고유 id가 있다
		return roomMap.get(id);						// id를 key로 사용하여 방을 찾아 반환
	}
	
	public RoomDTO createChatRoom(String name) {	// 방 생성, 이름을 전달받는다
		RoomDTO room = RoomDTO.create(name);		// 이름을 전달하여 방 객체 생성
		roomMap.put(room.getRoomId(), room);		// 방의 id를 key로 지정하여 Map에 저장
		return room;								// 생성한 방을 반환
	}
}
