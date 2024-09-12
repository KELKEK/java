package com.shinhan.day06;

abstract class Animal{
	
	abstract void sound();
	void sound2() {
		System.out.println("일반메서드는 가능");
	}
}

class Cat extends Animal{

	void sound() {
		System.out.println("야옹");
	}
	
}


class Dog extends Animal{

	void sound() {
		System.out.println("멍멍");
	}
	
}


public class AbstractTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		call(new Cat());
		call(new Dog());
	}

	private static void call(Animal ani) {
		// TODO Auto-generated method stub
		// 변수나 함수는 타입을 따른다.
		ani.sound();
		//공통적인 함수를 만들기 위해서라도 추상클래스는 필요하다.
		//자식들의 함수들은 부모의 함수에 override된 것
	}

}
