package com.shinhan.day06;

//Object는 최상위 클래스
class Parent2 extends Object{
	int score = 100;
	
	void show() {
		System.out.println("부모에서 score 접근 : " + score);
	}
}

class Child2 extends Parent2{
	String score = "A학점";
	//@Override <- 오버라이드가 제대로 되었는가 확인, 넣었을 때 에러나면 오버라이드 안된것
	//Override : 이름, 매개변수, return, modifier 확인하기
	//이름이 같고, 매개변수가 틀린 것은 Overloading
	protected void show(String a) {//범위가 더 넓어진 Override
		//이 때는 자식의 show를 따른다. 이 함수 원래는 print()였음
		System.out.println("===========");
		System.out.println("자식이 score 접근 : " + score);
		show();//자신의 class에 재정의되어있는 메서드 수령
		super.show();//super는 부모를 의미
	}
	
	void show() {
		System.out.println("자식자식몬에서 score 접근 : " + score);
	}
}

public class InheritanceTest2 {

	public static void main(String[] args) {
		Child2 aa = new Child2(); // Object -> Parent2 -> Child2 순으로 생성
		System.out.println(aa.score);
		//aa.print();//이 떄의 score는
		aa.show();//부모의 score를 따른다.
		aa.show("*********");
		
	}

}
