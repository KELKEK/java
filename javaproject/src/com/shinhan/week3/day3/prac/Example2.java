package com.shinhan.week3.day3.prac;

import java.util.Arrays;
import java.util.List;

public class Example2 {
	public static void main(String[] args) {
		List<Member> list = Arrays.asList(
				new Member("홍길동", 30),
				new Member("신용권", 40),
				new Member("감자바", 26));
		double avg = list.stream()
				.mapToInt(st->st.getAge())
				.average()
				.orElse(0);
		
		
		//double 타입 리턴은 불가
				list.stream()
				.mapToInt(st->st.getAge())
				.average()
				.ifPresentOrElse(a->{System.out.println("있음 avg = " + a);}, ()->{System.out.println("data가 없음");});
				//.orElse(0); //배열이 없을 경우에도 고려해주는 것이 좋다.
				//.getAsDouble(); //확실하게 배열이 있을 경우에는 이 방법도 있지만 비추라고 하심
		System.out.println("평균 나이 : " + avg);
	}
}

class Member {
	private String name;
	private int age;

	public Member(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}
}