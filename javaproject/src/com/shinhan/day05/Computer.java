package com.shinhan.day05;

//접근지정자(Modifier)
/*
 * 1,public : 모든 패키지에서 접근 가능
 * 2,protected : 상속받으면 다른 패키지에서도 접근 가능, 같은 패키지에서 접근 가능
 * 3,생략(default) : 같은 패키지에서 접근 가능
 * 4,private : 같은 class 내에서만 접근 가능(정보은닉, 캡슐화)
 */
//class 접근지정자는 : public, 생략(default)

public class Computer {
	public String model;
	public int price;
	public Computer(){
		System.out.println("default생성자 정의됨");
	}
	
	public void setModel(String model) {
		this.model = model;
	}
	
	public void Print() {
		System.out.println(price);
	}
}
