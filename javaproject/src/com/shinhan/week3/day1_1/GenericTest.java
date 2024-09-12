package com.shinhan.week3.day1_1;

public class GenericTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Applicant<Person> applicant = new Applicant<>(new Person());
		Applicant<Worker> applicant2 = new Applicant<>(new Worker());
		Applicant<Student> applicant3 = new Applicant<>(new Student());
		Applicant<HighStudent> applicant4 = new Applicant<>(new HighStudent());
		Applicant<MiddleStudent> applicant5 = new Applicant<>(new MiddleStudent());
		Course.registerCourse1(applicant);
		Course.registerCourse1(applicant2);
		Course.registerCourse1(applicant3);
		Course.registerCourse1(applicant4);
		Course.registerCourse1(applicant5);
		//extends, super에 따라 되는 범위가 다르다. extends <- 자기자신 클래스포함 아래까지 가능, 타입을 제한
		//super <- 자기를 포함해서 위 클래스까지 포함
	}

}
