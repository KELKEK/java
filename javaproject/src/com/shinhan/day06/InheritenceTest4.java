package com.shinhan.day06;

//{} : 구현
//추상 : 정의는 있고 구현은 없다.(구현은 자식클래스가 한다.)
//abstract method : 정의는 있고 구현은 없다.
//abstract class : class 안에 추상메서드가 하나라도 있다., 객체생성 불가
abstract class Vehicle {
	abstract void run();
	// System.out.println("부모의 run");
	// 정의는 있고 구현은 없다.

	void print() {
		System.out.println("일반메서드");
	}
}//직접 객체생성 불가

abstract class Truck extends Vehicle{
	abstract void run(); // 아직 구현을 못해서 미정일경우

	void print2() {
		System.out.println("구현메서드");
	}
}
//추상메서드를 상속받은 자식은 반드시 추상메서드를 구현할 의무가 있다.
class Trucks extends Truck{
	void run() {
		System.out.println("추상메서드는 반드시 자식이 구현할 의무가 있다.");
	}//구현 못하면 에러남
}

class Bus extends Vehicle {
	void run() {
		System.out.println("(BUS)자식 override...자식의 run");
	}
}

class Taxi extends Vehicle {
	void run() {
		System.out.println("(TAXI)자식 override...자식의 run");
	}
}

class Driver {
	void drive(Vehicle vv) {
		vv.run();// 버스가 들어오면 버스가 run, 택시가 들어오면 택시가 run
	}
}

class Tire {
	void roll() {
		System.out.println("부모가 정의한 roll");
	}
}

class Hankook extends Tire {
	void roll() {
		System.out.println("한국타이어가 정의한 roll");
	}
}

class Kumho extends Tire {
	void roll() {
		System.out.println("금호타이어가 정의한 roll");
	}
}

class Car {
	Tire tire;// 어느 회사의 타이어가 올지는 모름

	Car(Tire tire) {
		this.tire = tire;
	}

	void go() {
		tire.roll();
	}
}

//다형성
public class InheritenceTest4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=====매개변수의 대형성=======");
		Driver driver = new Driver();
		driver.drive(new Bus());
		driver.drive(new Taxi());
		// 자식은 부모에 들어갈 수 있기 때문

		System.out.println("=====field의 대형성=======");
		Car car1 = new Car(new Hankook());
		Car car2 = new Car(new Kumho());

		car2.go();
		car1.go();
	}

}
