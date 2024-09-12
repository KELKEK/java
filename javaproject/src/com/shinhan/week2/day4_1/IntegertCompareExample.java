package com.shinhan.week2.day4_1;

import java.util.Random;

public class IntegertCompareExample {

	public static void main(String[] args) {
		double d = Math.random();
		System.out.println(d);

		Random r = new Random();
		double d2 = r.nextDouble(10);
		System.out.println(d2);
		
		int i = r.nextInt(45);
		System.out.println(i+1);
	}

	public static void f(String[] args) {
		// TODO Auto-generated method stub
		Integer obj1 = 100;
		Integer obj2 = 100;
		Integer obj3 = 300;
		Integer obj4 = 300;

		System.out.println(obj1 == obj2);// 값의 범위가 -128~127이면 ==은 값을 비교하고 그 이외에는 번지를 비교하기 때문이다.
		System.out.println(obj3 == obj4);// 주소비교이므로 값비교 할 때는 쓰지말자
		System.out.println(obj1.equals(obj2));
		System.out.println(obj3.equals(obj4));
	}
}
