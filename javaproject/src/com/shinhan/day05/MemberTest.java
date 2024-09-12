package com.shinhan.day05;

public class MemberTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MemberService memberService = new MemberService();
		boolean result = memberService.login("hong", "12345");
		
		if(result) {
			System.out.println("로그인 되었습니다.\n");
			memberService.logout("hong");
		}else {
			System.out.println("id 혹은 password가 올바르지 않습니다.");
		}
	}

}
