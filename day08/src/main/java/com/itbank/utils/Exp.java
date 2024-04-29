package com.itbank.utils;

// enum 타입은 싱글톤처럼, 기본생성자로 객체를 생성하지 않고
// 클래스의 정적메서드를 이용하여 생성한다

interface IntOperator {		// 함수형 인터페이스, 람다식으로 함수를 구현하면서 객체 생성
	int calc(int x, int y);
}

public enum Exp {

	// private static final PLUS = "+";
	PLUS("+", (x, y) -> x + y),
	MINUS("-", (x, y) -> x - y),
	MULTI("*", (x, y) -> x * y),
	DIVIDE("/", (x, y) -> x / y);
	
	
	private final String operator;
	private final IntOperator lambda;
	
	private Exp(String operator, IntOperator lambda) {
		this.operator = operator;
		this.lambda = lambda;
	}
	public String getOperator() {
		return operator;
	}
	public int getAnswer(int x, int y) {
		return lambda.calc(x, y);
	}
}