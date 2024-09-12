package com.shinhan.week2.day1review;

public class SnowTireExample {
	public static void main(String[] args) {
		SnowTire snowTire = new SnowTire();
		
		//자동형변환
		//부모 = 자식
		Tire tire = snowTire;
		
		snowTire.run();
		//메서드는 타입을 따른다. Override되어있다면 재정의된 메서드가 호출된다.
		tire.run();
		tire.run2();
		//타입(Tire)를 따르므로 run2메서드도 제대로 호출 가능
		
		((SnowTire)tire).run3();
		//강제형변환
		
		//더 바람직한 방법
		if(tire instanceof SnowTire s) {
			s.run3();
		}
		
		//Tire tire2 = new Tire();
		//SnowTire ss = (SnowTire)tire2;
		//Class casting exception
		//컴파일에러는 아니지만 예외발생
	}	
}
