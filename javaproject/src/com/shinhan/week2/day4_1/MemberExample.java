package com.shinhan.week2.day4_1;

import lombok.AllArgsConstructor;

public class MemberExample {
	public static void main(String[] args) {
		Member member = new Member("blue", "이파란");
		System.out.println(member);
	}
}

@AllArgsConstructor
class Member {
	private String id;
	private String name;

	//public Member(String id, String name) {
	//	this.id = id;
	//	this.name = name;
	//}
//여기에 코드를 작성하세요.

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append(id).append(":").append(name);
		return builder.toString();
	}
	
}
