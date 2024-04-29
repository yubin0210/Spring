package com.itbank.service;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itbank.model.Upload1DTO;
import com.itbank.repository.UploadDAO;

@Service
public class UploadService {
	
	@Autowired private UploadDAO dao;
	private String saveDirectory = "C:\\upload";
	
	public UploadService() {
		// 스프링 빈이 생성될때 (=서버가 시작될 때) saveDirectory 경로를 체크하고 없으면 새로 만든다
		File dir = new File(saveDirectory);
		if(dir.exists() == false) {
			dir.mkdirs();
		}
	}

	public int upload(Upload1DTO dto) {
		// originalFileName과 storedFileName을 만들어서 dto에 넣어주고 dao로 넘겨야 한다
		String originalFileName = dto.getUpload().getOriginalFilename();
		
		// 마지막 .의 위치(lastIndexOf)부터 끝까지 잘라낸다(substring)
		String ext = originalFileName.substring(originalFileName.lastIndexOf("."));
		
		// 새로 저장될 이름은 중복되지 않도록 UUID를 사용한다
		String storedFileName = UUID.randomUUID().toString().replace("-", "");
		storedFileName += ext;
		
		// 새로 만들어진 이름으로 파일을 지정한 위치에 업로드한다
		File f = new File(saveDirectory, storedFileName);
		try {
			dto.getUpload().transferTo(f);	// 실제 파일이 생성되는 함수
			// (서버 메모리)MultipartFile -> (지정한 위치의 저장장치)java.io.File
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		dto.setOriginalFileName(originalFileName);
		dto.setStoredFileName(storedFileName);
		
		return dao.insert(dto);
	}

	public List<Upload1DTO> getList() {
		return dao.selectList();
	}

	public int delete(int idx) {
		// DB에서 데이터를 삭제하기 전에, 데이터를 불러와서, 실제 저장된 파일도 삭제하고, 데이터를 삭제한다
		Upload1DTO dto = dao.selectOne(idx);
		File f = new File(saveDirectory, dto.getStoredFileName());
		if(f.exists()) {
			f.delete();
		}
		int row = dao.delete(idx);
		return row;
	}

}









