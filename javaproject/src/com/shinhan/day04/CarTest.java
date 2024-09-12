package com.shinhan.day04;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method1();
		method2();
	}

	private static void method2() {
		// TODO Auto-generated method stub
		Car c1 = new Car("K7", "검정", 400);
		System.out.println(c1);
		//오버라이드의 결과 c1의 결과와 c1.toString()의 결과는 완전히 같다.
	}

	private static void method1() {
		// TODO Auto-generated method stub
		// 접근지정자(Modifier)가 private인 경우 외부에서 접근불가하다.
		// 접근하고자 한다면 기능이 추가되어야 한다.
		// 읽기 기능 : getter
		// 쓰기 기능 : setter
		//JavaBeans기술의 규칙 : set대문자
		//ㄴ ex) setCompany, getCompany
		Car c1 = new Car("ABC모델", "black", 300);
		String result = c1.carInfoPrint("***");
		
		System.out.println(result);
		
		c1.powerOn();
		//객체의 참조변수 c1을 이용해야만 호출이 가능하다(그냥 powerOn(); 안됨)
	}

}
