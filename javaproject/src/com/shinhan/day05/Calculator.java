package com.shinhan.day05;

public class Calculator {
	//1, static field
	static double pi = 3.141592;
	static String company = "퍼스트존";
	static String company2;
	String color;
	//2, static block
	static {
		System.out.println("Class load 시에 1회 수행");
		company2 = "상공회의소";
	}
	//instance block
	{
		System.out.println("객체 생성마다 1회 수행");
	}
	
	//3, static method
	static double plus(int a, int b){
		Calculator cal = new Calculator();
		cal.color = "red";//return 뒤에 쓰면 에러나므로 return 앞에 쓰자.
		return a+b+pi;
	}//new 안해도 쓸 수 있음
	double minus(int a, int b){
		color = "red";
		return a-b+pi;

	}//new 해야 쓸 수 있음(객체 생성 시 사용 가능)
}
