package com.shinhan.day05;

public class Book {
	// 1, field
	// class 변수
	public static int BookCount;
	public String title;
	public int price; // instance 변수

	// final(최종), 1회만 값을 할당하고 더 이상 값 변경 불가(수정불가)
	// 1)선언 시 초기화, 2)생성자로 초기화, 3)instance block{}으로 초기화
	// instance 변수이다.
	// final은 상속, 재정의 불가
	final String publish = "한빛미디어";
	final String publish2;
	final String publish3;

	// 2, constructor
	public Book() {
		System.out.println("default 생성자");
		this.publish2 = "default 생성자에서 초기화";
		//this.ISBM = "232312313";이거는 안됨
	}

	public Book(String publish2) {
		this.publish2 = publish2;
	}

	{
		publish3 = "한빛미디어3";
	}
	
	// 상수
	public static final String ISBM = "1234-5678";// 대문자로 선언
	public final static String ISBM2; // 순서 상관 없음
	static {
		ISBM2 = "8888-9999";
	}//상수는 그냥 선언을 하거나 정적블록을 이용해서 선언해야 한다.

	// 3, method
	void test1() {
		// publish = "한비미이";, 값 변경 불가
	}
	// 4, block
	// 5, inner class
}

//Overloading : 이름같고 매개변수 사양다르다. return타입은 상관X
