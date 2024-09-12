package com.shinhan.day04;

public class Employee {
	private String name;
	private String title;
	private int baseSalary;
	private int totalSalary;

	public Employee(String name, String title, int baseSalary) {
		this.name = name;
		this.title = title + "님";
		this.baseSalary = baseSalary;
	}

	public void getTotalSalary() {
		
		  switch (title){
		  case "부장님" -> 
		  { totalSalary = (int) (baseSalary * 1.25); }
		  case "과장님" -> 
		  { totalSalary = (int) (baseSalary * 1.15); } 
		  default -> 
		  { totalSalary = (int) (baseSalary * 1.05); }
		  }
		  //switch문은 case비교할 때 주소가 아닌 값으로 비교가 됨(.equals랑 같은 효과)
		
		/*
		if (title.equals("부장")) {
			totalSalary = (int) (baseSalary * 1.25);
		} else if (title.equals("과장")) {
			totalSalary = (int) (baseSalary * 1.15);
		} else {
			totalSalary = (int) (baseSalary * 1.05);
		}
		*/
	}// 실제로 get <- 이녀석을 함수로 넣을거면 void보단 return이 가능한 자료형을 쓰자.

	public void print() {
		System.out.println(title + "직급의 " + name + "씨의 본봉은 " + baseSalary + " 원이고 총급여는 " + totalSalary + " 원입니다.");
	}
}
