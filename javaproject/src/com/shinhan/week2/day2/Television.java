package com.shinhan.week2.day2;


//interface를 구현한 구현 class
//추상메서드를 반드시 구현할 의무가 있다.
//extend Object는 자동으로 생략되어서 나타남
public class Television extends Object implements RemoteController{

	
	//추상메서드들이 다 들어옴
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName() + "method1()");
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName() + "전원켠다.");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName() + "전원끈다.");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println(getClass().getSimpleName() + "method2()");

	}

	
	//default 메서드는 재정의 가능
	@Override
	public void method3() {
		// TODO Auto-generated method stub
		// 부모에 의한 코드도 실행 가능
		RemoteController.super.method3();
		System.out.println("default메서드 재정의 함");
	}
	
	//@Override 오버라이드 아님
	//클래스에서 생성한 메서드
	void method4() {
		RemoteController.method4();
		//Television과는 아무런 상관없는 메소드이기 때문에 RemoteController.super 이럴 필요 없음
		System.out.println("메서드 재정의가 아닌 단순히 메서드 추가");
	}

}
