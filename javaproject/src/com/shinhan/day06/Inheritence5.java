package com.shinhan.day06;

class A{
	int score = 100;
	void print() {
		
	}
}

class B extends A{
	int score2 = 99;
	void print2() {
		
	}
}
class C extends B{
	int score3 = 98;
	void print2() {
		
	}
}
class D extends B{
	
}
class E extends C{
	
}



public class Inheritence5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method1();
		method2();
	}

	private static void method2() {
		// TODO Auto-generated method stub
		//A타입이므로 변수의 타입을 따른다.
		A a = new B();
		A a2 = new C();
		System.out.println(a.score);
		//System.out.println(a.score2);
		a.print();
		//print2();
		B b = (B) a;
		System.out.println(b.score2);
		b.print2();
		C var1 = (C) a2;
		System.out.println(var1.score3);
		
		if(a instanceof B bb) {
			System.out.println(bb.score2);
		}
	}

	private static void method1() {
		// TODO Auto-generated method stub
		A a = new A();
		Object obj = new A();
		
		
		Object b1 = new B();
		B b2 = new B();
		A b3 = new B();
		
		
		Object d1 = new D();
		D d2 = new D();
		B d3 = new D();
		A d4 = new D();
	}

}
