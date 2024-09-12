package com.shinhan.day05;

public class CalTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(Calculator.company);
		System.out.println(Calculator.company2);
		System.out.println(Calculator.plus(1, 2));
		//System.out.println(Calculator.minus(1, 2)); 객체생성을 하지 않아 사용불가
		
		new Calculator().minus(1, 2);
		//꼭 굳이 변수에 넣어야만 객체생성이 되는 것은 아니다.	
		Calculator cal = new Calculator();
		cal.minus(1, 2);
	}
}
