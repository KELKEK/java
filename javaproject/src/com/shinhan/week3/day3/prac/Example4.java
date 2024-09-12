package com.shinhan.week3.day3.prac;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Example4 {
	public static void main(String[] args) {
		List<Member2> list = Arrays.asList(
				 new Member2("홍길동", "개발자"),
				 new Member2("김나리", "디자이너"),
				 new Member2("신용권", "개발자")
				 );

				 Map<String, List<Member2>> groupingMap = list.stream()
						 .collect(Collectors.groupingBy(j->j.getJob()));

				 System.out.println("[개발자]");
				 groupingMap.get("개발자").stream()
				 .forEach(d->System.out.println(d));


				 System.out.println();

				 System.out.println("[디자이너]");
				 groupingMap.get("디자이너").stream()
				 .forEach(d->System.out.println(d));
				}
}

class Member2 {
	private String name;
	private String job;

	public Member2(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}

	@Override
	public String toString() {
		return "{name:" + name + ", job:" + job + "}";
	}
}