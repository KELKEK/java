package com.shinhan.day04;

//class : 틀(공통된 특징 행위를 정한다. 따라서 값이 없다.)
//object : 각각의 다른 object와 구별되는 독립된 특징, 행위
public class Korean {
	//1, field
	//private 등으로 정보 은닉 시 외부에서 기능을 바꿀 수 없다.(애초에 KoreanTest에서 접근도 안됨)
	//이 상황에서는 변수는 private로 정보은닉을 했지만 생성자와 메서드는 은닉하지 않았기 때문에 KoreanTest에서 접근이 가능하다.
	//실제로 print 등의 메서드를 통해 접근은 가능하지만 private로 되어있는 것들의 값은 바꿀 수 없다(nation의 대한민국)
	private String nation = "대한민국";//바꿀 수 있지만 초기값도 줄 수 있다.
	private String name;
	private String ssn;
	 
	//2, constructor : 값 초기화를 목적으로 한다.
	Korean(String name, String ssn){
		this.name = name;
		this.ssn = ssn;
	}
	
	Korean(String name){
		this.name = name;
	}
	
	//3. 메서드(기능) : return type 필수
	void print() {
		System.out.println(nation);
		System.out.println(name);
		System.out.println(ssn);
	}
}
