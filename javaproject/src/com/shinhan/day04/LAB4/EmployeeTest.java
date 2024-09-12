package com.shinhan.day04.LAB4;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee emp1 = new Employee("2147", "김삿갓", 10000);
		
		System.out.println(emp1.toString());
		emp1.setBaseSalary(13000);
		System.out.printf("총 월급은 : %d\n", (int)emp1.getSalary(0.1));
		
		
		Book book = new Book("자바", 30000);
		System.out.println(book.toString());
	}

}
