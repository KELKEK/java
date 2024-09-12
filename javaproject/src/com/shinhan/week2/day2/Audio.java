package com.shinhan.week2.day2;

public class Audio implements RemoteController{

	int a = 100;
	static int b = 200;
	public Audio() {
		System.out.println("Audio default 생성자");
	}
	
	//오디오가 가지는 메서드
	void show() {
		System.out.println("Adio show 메서드");
	}
	
	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("Audio method1() 구현");
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("turnOn 구현");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("turnOff 구현");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("Audio method2() 구현");
	}
	
}
