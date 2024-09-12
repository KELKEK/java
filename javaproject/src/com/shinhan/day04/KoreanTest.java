package com.shinhan.day04;

public class KoreanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
	}

	private static void method1() {
		// TODO Auto-generated method stub
		//1, 객체참조변수선언(1+2 같이 해도 됨)
		Korean k1 = new Korean("신현상", "12345");//기본생성자 말고 다른 생성자가 있으면 기본 생성자가 없을 경우 다음과 같이 할 수 없다.
		Korean k2 = new Korean("신현상");
		//2, 객체생성
		//3, 객체사용
		k1.print();
		k2.print();
	}
	
}
