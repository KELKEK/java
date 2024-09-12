package com.shinhan.day05;

public class Member {
	String name;
	String id;
	String password;
	int age;

	Member(String name, String id) {
		this.name = name;
		this.id = id;
	}

}

class MemberService {
	
	boolean login(String id, String password) {
		return id.equals("hong") && password.equals("12345");
	}
	
	void logout(String id) {
		System.out.println(id + "님이 로그아웃 되었습니다.");
	}
}


class Printer{
	
	public void println(int value) {
		System.out.println(value);
	}
	public void println(boolean value) {
		System.out.println(value);
	}
	public void println(double value) {
		System.out.println(value);
	}
	public void println(String value) {
		System.out.println(value);
	}
}