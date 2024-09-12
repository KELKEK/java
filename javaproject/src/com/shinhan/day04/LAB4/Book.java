package com.shinhan.day04.LAB4;

public class Book {
	private String title;
	private int price;
	/*
	Book(String title, int price){
		this.title = title;
		this.price = price;
	}*/
	public Book(String title, int price) {
		super();
		this.title = title;
		this.price = price;
	}
	//자동 생성자 만들기
	//ㄴ 마우스우클릭 + source + Generate constructor using fields 
	//(밑에서 3번째)
	
	public void setTitle(String title){
		this.title = title;
	}
	

	public String getTitle() {
		return title;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getPrice() {
		return price;
	}

	@Override
	//부모 함수의 object의 toString의 정의를 재정의
	//원래 부모클래스(object클래스) 개념 : getClass().getName() + '@' + Integer.toHexString(hashCode())
	//오버라이딩이랑 오버로딩이랑 차이점 정리해서 쓰자
	public String toString() {
		// TODO Auto-generated method stub
		return "제목은 " + title + " 가격은 " + price;
	}
}
