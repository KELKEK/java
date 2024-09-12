package com.shinhan.week2.day2;

//인터페이스는 두 객체를 연결하는 역할
//정의는 있고 구현은 없다. (단, default메서드를 쓰면 구현가능) (규격서)
//interface를 구현한 class를 만들어 함수를 구현한다. (만약 10개 구현 class 만듦)
//생성자를 가질 수 없다.
public interface RemoteController {
	//1. 상수
	int CHANNEL = 10;
	public static final int CHANNEL2 = 20; //둘 다 같은 표현
	//2. 추상메서드
	void method1();
	void turnOn();
	void turnOff();//생략 시 default접근지정자는 public(따라서 다른 클래스에서 오버라이드 시 public만 가능)
	public abstract void method2();//둘 다 같음(public abstract 생략 가능)
	//3. default메서드(구현 class가 공통적으로 가지는 기능을 구현, 재정의 가능)
	//메서드 재정의를 통해 다른 클래스들이 각각의 기능을 보유할 수 있도록 한다.
	default void method3() {
		System.out.println("default method...재정의 가능");
		method5();
	}
	//4. static메서드('interface가 가지는 기능', 구현class가 재정의 불가능
	//실행 시 바로 올라오는 것(static)
	static void method4() {
		System.out.println("static method...재정의 불가능");
	}
	//5. private메서드(interface 내에서 모듈화 또는 재사용을 위해 사용(내부에서만 사용 가능))
	//void method() {} 과 같이 일반메서드는 불가하다, 생성자도 불가
	private static void method5() {
		System.out.println("private method...외부접근불가, default 메서드가 호출한다.");
	}
	
}
