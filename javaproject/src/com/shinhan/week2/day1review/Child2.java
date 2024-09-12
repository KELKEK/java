package com.shinhan.week2.day1review;

public class Child2 extends Parent2{
	public String name;
	
	public Child2() {
		//1. default는 super() <- 생략 시 super()가 자동호출
		//따라서 super() 제외 다른 생성자는 무조건 첫줄에 명시해줘야 한다.
		this("홍길동");//자신의 class의 다른 생성자 호출
		System.out.println("Child() call");
	}

	public Child2(String name) {
		//마찬가지로 super()가 기본 생성자 <- object가 생성된다.
		this.name = name;
		System.out.println("Child(String name) call");
	}
}

