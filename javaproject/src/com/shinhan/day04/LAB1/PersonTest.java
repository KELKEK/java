package com.shinhan.day04.LAB1;

public class PersonTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Person[] human = new Person[4];
		
		human[0] = new Person(23, "황상일");
		human[1] = new Person(24, "황상이");
		human[2] = new Person(25, "황상삼");
		human[3] = new Person(26, "황상구");
		
		for(Person person : human) {
			person.selfIntroduce();
		}
		
		System.out.printf("총 인구수는 : %d", Person.numberOfPersons);
	}

}
