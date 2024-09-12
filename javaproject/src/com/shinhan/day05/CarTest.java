package com.shinhan.day05;

public class CarTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method1();
		method3();
	}

	private static void method3() {
		// TODO Auto-generated method stub
		//1, 객체참조변수 선언 + 생성 + 사용
		System.out.println("Car 댓수 : " + Car.carCount);
		System.out.println("Car 회사 : " + Car.company);
	/*	Car car1 = new Car("A모델", 10000);
		Car car2 = new Car("B모델", 20000);
		Car car3 = new Car("C모델", 30000);
		Car car4 = new Car("D모델");
		Car car5 = new Car(50000);
		System.out.println("생성 후 Car 댓수 : " + Car.carCount);
		*/
		//계속 다 호출하기는 코드가 너무 길어지므로 배열변수로 선언해보자
		//배열 변수 선언 + 생성
		Car[] arr = new Car[5];
		//객체참조변수 선언 + 생성, 사용
		arr[0] = new Car("A모델", 10000);
		arr[1] = new Car("B모델", 20000);
		arr[2] = new Car("C모델", 30000);
		arr[3] = new Car("D모델");
		arr[4] = new Car(50000);
		for(Car a : arr) {
			a.carInfoPrint("-----------------");
		}
		System.out.println("생성 후 Car 댓수 : " + Car.carCount);
	}

	private static void method1() {
		//static은 class소유이므로 object생성과 관계없다.
		// TODO Auto-generated method stub
		System.out.println("Car 댓수 : " + Car.carCount);
		System.out.println("Car 회사 : " + Car.company);
		Car.carInfoPrint2("*********************");
		int a = 100;
		method2();
	}

	private static void method2() {
		// TODO Auto-generated method stub
		System.out.println("=====================");
	}

}
