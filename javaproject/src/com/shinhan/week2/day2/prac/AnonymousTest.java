package com.shinhan.week2.day2.prac;


interface Vehicle{
	public void run();
}

class Anonymous{
	//1, 익명구현 class를 field로 사용하기
	Vehicle field = new Vehicle() {
		public void run() {System.out.println("자전거가 달립니다.");}
	};
	
	void method1() {
	//2, 익명구현 class를 지역변수로 사용하기
		Vehicle localVar = new Vehicle() {
			public void run() {System.out.println("승용차가 달립니다.");
		}
		
	};
	Vehicle localVar2 = () -> System.out.println("승승승용차가 달립니다.");
	localVar.run();	
	localVar2.run();
	}
	void method2(Vehicle v) {
		v.run();
	}
}

public class AnonymousTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		//3, 익명구현 class를 파라메터로 사용하기
		anony.method2(new Vehicle() {
			
			public void run() {
				System.out.println("트럭이 달립니다.");
			
		}
		});
		anony.method2(() -> System.out.println("트럭이 달립니다."));
	}

}

