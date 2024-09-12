package com.shinhan.day04;

public class EmployeeTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Employee[] emp = new Employee[4];
		
		emp[0] = new Employee("이부장", "부장", 15000000);
		emp[1] = new Employee("김과장", "과장", 13000000);
		emp[2] = new Employee("최대리", "대리", 12000000);
		emp[3] = new Employee("박사원", "사원", 10000000);
		
		for(int i = 0; i < emp.length; i++) {
			emp[i].getTotalSalary();
			emp[i].print();
		}
	}

}
