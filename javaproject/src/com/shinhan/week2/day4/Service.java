package com.shinhan.week2.day4;

public class Service {

	@PrintAnnotation
	public void method1(){
		System.out.println("method1....");
	}
	@PrintAnnotation("*")//default로 "*"이 들어간다.
	public void method2(){
		System.out.println("method2....");
	}
	@PrintAnnotation(value = "#", number = 20)//default로 "*"이 들어간다.
	public void method3(){
		System.out.println("method3....");
	}
	@PrintAnnotation(value = "$", number = 30)//default로 "*"이 들어간다.
	public void method4(){
		//subject = "week"; subject2 = "framework";
		System.out.println("method4....");
	}
}
