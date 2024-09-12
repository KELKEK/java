package com.shinhan.day04.LAB4;

public class Employee /*extends Object*/ {//기본적으로 object부모 클래스를 상속
	private String id;
	private String name;
	private int baseSalary;
	
	Employee(String id, String name, int baseSalary){
		this.id = id;
		this.name = name;
		this.baseSalary = baseSalary;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(int baseSalary) {
		this.baseSalary = baseSalary;
	}
	
	double getSalary(double bonus) {
		//double salary = baseSalary * (1 + bonus);
		//return salary;
		return baseSalary * (1 + bonus);
	}

	//부모가 물려준 함수를 재정의 : override라고 한다.
	//이름 같고, 매개변수 같고, return 같고, 접근제한자가 같거나 더 넓어져야 한다.
	@Override
	public String toString() {
		return name + "(" + id +  ") 사원의 기본급은 " + baseSalary + "원 입니다.";
	}
	
	
}
