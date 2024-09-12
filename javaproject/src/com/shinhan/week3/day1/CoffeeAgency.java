package com.shinhan.week3.day1;

public class CoffeeAgency implements Rentable<CoffeeMachine>{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CoffeeMachine rent() {
		// TODO Auto-generated method stub
		return new CoffeeMachine();
	}

	
	//받는거 만들기, 오버로딩씀
	void method1(CoffeeMachine coffee) {
		coffee.method();
	}
}
