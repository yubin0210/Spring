package com.itbank.interceptor;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;

import com.itbank.model.MemberDTO;

// 1) 인터셉터의 모든 기능을 직접 구현할 수 없으므로, 만들어진 클래스/인터페이스를 상속/구현한다
public class AdminInterceptor /*1*/ implements HandlerInterceptor {
	
	// 2) 메뉴를 클릭했을 때, 로그인 상태에 따라 컨트롤러의 함수를 실행하지 않아야 하므로 preHandle을 사용한다
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		// 3) 조건을 판별하기 위해 필요한 값을 가져온다
		// 로그인 정보는 세션에 있고, request 객체에서 가져올 수 있다
		HttpSession session = request.getSession();
		
		// 4) 세션에 들어있는 로그인 정보는 MemberDTO 타입으로 받을 수 있다
		// getAttribute() 는 Object 타입을 반환하므로, 좌우 자료형을 맞추기 위해 캐스팅한다
		MemberDTO login = (MemberDTO) session.getAttribute("login");
		
		// 5) 만약, 로그인 객체가 없거나, 로그인되어있지만 관리자가 아니라면 진행을 중단해야 한다
		if(login == null || login.getUserid().equals("admin") == false) {
			// 6) alert.jsp 는 내부 설정 폴더(WEB-INF)에 있으므로, 리다이렉트로 접근할 수 없다
			// 따라서 forward로 진행한다
			// 7) forward하기 위해서는 이동할 경로를 설정해야 한다 (prefix + viewName + suffix)
			String path = "/WEB-INF/views/alert.jsp";
			
			// 8) forward를 수행하기 위한 RequestDispatcher 객체를 불러온다
			RequestDispatcher rd = request.getRequestDispatcher(path);
			
			// 9) forward하기 전에 필요한 값을 setAttribute로 넣어준다 (mav.addObject() 와 동일하다)
			request.setAttribute("msg", "관리자만 접근할 수 있습니다");
			request.setAttribute("url", "/");
			
			// 10) forward를 수행한다
			rd.forward(request, response);
			return false;
		}
		
		return true;	// 계속 진행
	}

}
