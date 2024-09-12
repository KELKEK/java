package com.shinhan.day02;

//java프로그램은 class들로 이루어짐
//하나의 .java파일에 여러 개의 class가 가능(단, Public class는 파일 당 1개, 따라서 독립적 파일로 저장한다)
//파일은 저장되는 순간에 컴파일 함
public class ReviewDay01 {
	//쓸 수 있는 5가지 
	/*
	 * 1. 맴버변수
	 * 2. 생성자
	 * 3. 메서드
	 * 4. block
	 * 5. inner class
	 */
	public static void main(String[] args) {//함수 메인 메서드, 형식이 '정해져있음'

		System.out.println("main 시작");
		f1();
		System.out.println("main 끝");

	}

	private static void f1() {//static이 없으면 new로 호출할 때 올라감. 따라서 static을 써야 바로 쓸 수 있다.
		// TODO Auto-generated method stub
		System.out.println("f1함수 시작");
		//변수 : 하나의 값을 저장하기 위한 기억장소 이름
		//1. 변수를 선언 : data의 성격에 따라 기본형, 참조형
		//기본형 8가지 : byte, boolean(true, false <- java의 예약어는 소문자) <short, char < int, long, float < double
		//Wrapper class <- 기본형 + 기능 추가
		//Byte, Short, Character, Integer, Long
		//Float, Double, Boolean (대문자들을 사용한다는 것에 유의)
		int var1;
		Integer var2 = 100;
		//2. 변수 초기화 <- 하지 않으면 사용할 수 없다.
		var1 = Integer.MAX_VALUE - 1; // '='은 할당연산자
		//3. 변수를 사용
		System.out.println(var1);
		System.out.println(var2.floatValue());//int로는 불가능. 박싱, 언박싱 개념
		System.out.println("f1함수 끝");
		
	}

}

class Review2{
	
}