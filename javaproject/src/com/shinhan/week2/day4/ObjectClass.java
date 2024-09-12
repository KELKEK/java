package com.shinhan.week2.day4;

import java.util.HashSet;

public class ObjectClass {
	public static void main(String[] args) {
		//f1();
		//f2();
		f3();
	}

	private static void f3() {
		// TODO Auto-generated method stub
		String s = new String("자바");
		System.out.println(s.toString());
	}

	private static void f2() {
		// TODO Auto-generated method stub
		ComputerVO3 com1 = new ComputerVO3("A", 100, "Samsung");
		ComputerVO3 com2 = new ComputerVO3("A", 100, "Samsung");
		ComputerVO com3 = new ComputerVO("A", 100, "Samsung");
		ComputerVO2 aa = new ComputerVO2("A", 100, "Samsung");
		
		System.out.println(aa.model());
		System.out.println(aa.model());
		System.out.println(com1);
		System.out.println(com2);
		System.out.println(com1.equals(com2));
		
		//System.out.println(com1.getModel());
		System.out.println();
	}

	private static void f1() {
		// TODO Auto-generated method stub
		ComputerVO com1 = new ComputerVO("A", 20, "Samsung");
		ComputerVO com2 = new ComputerVO("A", 100, "Samsung");
		System.out.println(com1.toString());
		System.out.println(com2);//toString()호출된다. 원래 주소 return하지만 재정의 가능
		
		System.out.println(com1 == com2); //주소비교, c++은 '=='을 재정의 가능하지만 자바는 불가하다
		System.out.println(com1.equals(com2));//equals는 원래 주소비교이나 재정의 가능
	
		//동일객체비교(hashcode(), equals() 2개 메서드 재정의)
		//Set : 순서없고 중복불가
		HashSet<ComputerVO> computers = new HashSet<>();
		computers.add(com1);
		computers.add(com2);
		computers.add(new ComputerVO("A", 100, "Samsung"));
		System.out.println(computers.size());
		
		for(ComputerVO com : computers) {
			System.out.println(com);
		}
	}
}
