package com.shinhan.day06;

import com.shinhan.day05.Computer;

public class Modifier extends Computer {


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		method1();
	}

	private static void method1() {
		// TODO Auto-generated method stub
		Computer com1;
		com1 = new Computer();
		com1.model = "AA";
		com1.price = 2000;
		
		System.out.println(com1.model);
		com1.Print();
	}
//5일차 내용, 6일차 상속에서 다시 배울 예정
}
