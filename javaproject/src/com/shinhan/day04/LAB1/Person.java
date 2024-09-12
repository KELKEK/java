package com.shinhan.day04.LAB1;

public class Person {
	static int numberOfPersons; //전체 인구 수, person객체가 생성될 때마다 증가
	private int age;
	private String name;
	
	Person(){
		//numberOfPersons = 12;
		//name = "Anonymous";
		this(12, "Anonymous");
		//numberOfPersons++; 이거 굳이 2번 안써도 되더라(12번줄)
	}
	Person(int age, String name){
		this.age = age;
		this.name = name;
		numberOfPersons++;
	}
	
	void selfIntroduce(){
		System.out.println("내 이름은 "
				+ name
				+ "이며, 나이는"
				+ age
				+ "살 입니다.");
	}
	
	int getPopulation() {
		return numberOfPersons;
	}
	
}
