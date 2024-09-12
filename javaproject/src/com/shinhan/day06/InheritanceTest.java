package com.shinhan.day06;

class Parent extends Object{//extends Object는 생략가능 (lang
	String title = "부모에서 정의함";
	private String title2 = "부모다";
	Parent(){
		//super(); :  자동으로 부모의 default 생성자를 호출한다.
		System.out.println("부모의 default 생성자");
	}
	void show() {
		System.out.println("부모에서 정의한 show 메서드" + title2);
	}
	
	private void print() {
		System.out.println("부모에서 정의한 print 메서드 " + title2);
	}
}

class Child extends Parent{
	int title = 200;//재정의되면 본인의 것을 기본으로 함.
	int score = 100;
	Child(){
		//super(); : 자동으로 부모의 default 생성자를 호출한다.
		System.out.println("자식의 default 생성자");
	}
	void show2() {
		System.out.println("자식에서 정의한 show 메서드");
		System.out.println("자식에서 출력한 title : " + title);
		//System.out.println("title2 : " + title2); 부모의 private은 자식에서 접근 불가
		show();
		//print(); <-불가능
		
	}
}

public class InheritanceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		f1();
	}

	private static void f1() {
		Child ch1 = new Child();
		System.out.println(ch1.score);
		System.out.println("타이틀 실험 :  " + ch1.title);
		ch1.show();
		ch1.show2();
	}

}
