package com.itbank.exception;

// 예외 상황을 규정하는 클래스

public class AgeOutOfBoundsException extends Exception {

	private static final long serialVersionUID = 1L;
	
	// 정수가 범위를 벗어나면 발생하는 예외
	private int num;
	
	public AgeOutOfBoundsException(int num) {
		this.num = num;
	}
	
	@Override
	public String getMessage() {
		return "범위를 초과했습니다 (0 ~ 100) : " + num; 
	}
}
