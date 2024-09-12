package com.shinhan.week2.day4;

import java.io.FileNotFoundException;
//인터페이스는 정의는 있고 구현은 없다.
//함수가 하나가 아니므로 람다식 설정 불가
interface MyInterface{
	//접근권한들은 다 똑같은 말임
	public abstract void method1();
	void method2() throws FileNotFoundException;
	void method3() throws Exception;
	//추상메서드들로 이루어져있음
}

//구현class
//1, 부모의 throws Exception이 존재하지 않은 경우 : 쓰지 않거나 RuntimeException은 가능(원래 안써도 되는거라 그럼, 하위예외도 포함)
//2, 자식은 부모의 Exception보다 하위이어야한다(범위 넘어서지 않기), 자식은 예외 생략해도 됨
class MyClassImpl implements MyInterface{

	@Override
	public void method1() throws RuntimeException{
		// TODO Auto-generated method stub
		System.out.println("method1");
	}

	@Override
	public void method2() throws FileNotFoundException {
		// TODO Auto-generated method stub
		System.out.println("method2");
	}

	@Override
	public void method3() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("method3");
	}
	
}


public class Review {
	//1, field
	MyInterface a = new MyClassImpl();
	MyInterface a2 = new MyInterface() {
		public void method1() {}
		public void method2() {}
		public void method3() {}
	};//익명구현클래스를 필드(멤버변수)에서 사용
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//2, local변수
		MyInterface b = new MyClassImpl();
		MyInterface b2 = new MyInterface() {
			public void method1() {}
			public void method2() {}
			public void method3() {}
		};//익명클래스를 local변수에서 사용
		call(new MyClassImpl());	//3, 함수의 매개변수
		call(new MyInterface() {
		public void method1() {}
		public void method2() {}
		public void method3() {}
	});
	}

	private static void call(MyInterface c) {
		// TODO Auto-generated method stub
		
	}
}
