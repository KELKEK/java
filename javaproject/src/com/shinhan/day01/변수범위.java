package com.shinhan.day01;

public class 변수범위 {//public 클래스만 하나 존재, 나머지 클래스는 여러 개 있을 수 있다.
	//1. 멤버변수 : 자동초기화가 된다. 위치는 꼭 맨 위일 필요는 없지만 가독성 측면에서 위에 씀.
	//static메서드에서 non-static변수를 사용 불가(메모리에 올라오지 않음) <- 멤버변수에 static 넣음, 혹은 'new' 넣기
	static String model = "ABC";//처음에는 null로 정의된 값이 없음을 의미
	static int price;//정수는 0으로 초기화된다.
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f1();
		f2();
		System.out.println(price);
	}
	private static void f2() {
		//1. 변수 선언
		int a;//a는 int를 담을 수 있다.
		Car c1;//여러 개의 변수와 기능을 갖는 묶음, c1은 Car를 담을 수 있다.
		Car c2;
		//2. 객체 생성, 값을 할당한다.
		a = 100;//기본형은 100을 a에 저장한다.
		c1 = new Car(); //Car를 만든다.
		c2 = new Car();
		c2.model = "A";
		c2.price = 2000;
		//3. 객체 사용
		System.out.println(a);
		System.out.println(c1.model);
		System.out.println(c1.price);
		System.out.println(c2.model);
		System.out.println(c2.price);
		
		c1.drive();
		c2.drive();
	}
	private static void f1() {
		// 함수 내의 변수는 지역변수(stack에 저장된다.)이다. 반드시 초기화 후 사용한다.
		int a = 100;
		System.out.println("a = " + a);
		System.out.println("멤버변수접근 model = " + model);//static은 실행될 때 바로 올라가는데 멤버변수는 바로 올라가지 않으므로 에러남
		
	}

}

//class : 변수(data 저장 목적) + 메서드(기능)
//class : object를 만들기 위한 template(틀)(틀니 아님)
class Car{
	String model;
	int price;
	
	void drive() {
		System.out.println(model + " : " + price);
	}
}