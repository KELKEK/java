package com.shinhan.week3.day3.prac;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Example3 {
public static void main(String[] args) {
 List<Member1> list = Arrays.asList(
 new Member1("홍길동", "개발자"),
 new Member1("김나리", "디자이너"),
 new Member1("신용권", "개발자")
 );

 List<Member1> developers = list.stream()
		 .filter(s->s.getJob().equals("개발자"))
 		 .collect(Collectors.toList());//필터링한 요소 수집, java16부터는 tolist();만 써도 됨(요소 스트림에서 바로 list컬렉션을 얻어올 수 있음)
		 


 developers
 .stream()
 .forEach(m -> System.out.println(m.getName()));
}
}

class Member1 {
	private String name;
	private String job;

	public Member1(String name, String job) {
		this.name = name;
		this.job = job;
	}

	public String getName() {
		return name;
	}

	public String getJob() {
		return job;
	}
}