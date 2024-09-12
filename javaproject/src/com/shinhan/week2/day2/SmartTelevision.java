package com.shinhan.week2.day2;

public class SmartTelevision implements RemoteController, Searchable {

	@Override
	public void search(String url) {
		// TODO Auto-generated method stub
		System.out.println(url + "SmartTelevision search..");
	}

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		System.out.println("SmartTelevision method1..");
	}

	@Override
	public void turnOn() {
		// TODO Auto-generated method stub
		System.out.println("SmartTelevision turnOn..");
	}

	@Override
	public void turnOff() {
		// TODO Auto-generated method stub
		System.out.println("SmartTelevision turnOff..");
	}

	@Override
	public void method2() {
		// TODO Auto-generated method stub
		System.out.println("SmartTelevision method2..");
	}
	
}
