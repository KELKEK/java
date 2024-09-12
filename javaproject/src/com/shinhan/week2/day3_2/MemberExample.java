package com.shinhan.week2.day3_2;

public class MemberExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Member member = new Member("blue", "이파란");
		System.out.println(member);
	}

}

class Member {
	private String id;
	private String name;

	public Member(String id, String name) {
		this.id = id;
		this.name = name;
	}

	@Override
	public String toString() {
		return id + " : " + name;
	}

	
}
