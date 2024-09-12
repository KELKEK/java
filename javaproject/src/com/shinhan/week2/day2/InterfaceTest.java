package com.shinhan.week2.day2;


interface AInterface{
	public void method1();
}
interface BInterface extends AInterface{//인터페이스도 상속이 가능하다.
	void method2();
}
class MyClass implements BInterface{
	//method1, method2 모두 갖게됨
	public void method1() {}
	public void method2() {}
}

public class InterfaceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyClass a = new MyClass();
		a.method1();
		a.method2();
	}

}
