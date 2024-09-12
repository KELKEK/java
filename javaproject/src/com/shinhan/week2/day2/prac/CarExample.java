package com.shinhan.week2.day2.prac;

import com.shinhan.week2.day1review.Tire;

public class CarExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Car myCar = new Car();
		//instance inner class
		Car.Tire tire = myCar.new Tire();
		//static inner class
		Car.Engine engine = new Car.Engine();
		
		//local class는 method 내에서만 접근이 가능하다. 외부접근 불가
	}

}


class Car{
	class Tire{}
	static class Engine{}
	
	void method() {
		class Chair{//static 못 씀
			//로컬클래스
			void f1() {}
			//이 안에서만 접근
		}
		Chair cc = new Chair();
		cc.f1();
	}
	
}