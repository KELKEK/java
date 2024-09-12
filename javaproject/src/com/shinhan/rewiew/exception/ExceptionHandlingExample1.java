package com.shinhan.rewiew.exception;

public class ExceptionHandlingExample1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("[프로그램 시작]");
		printLength("ThisIsJava");
		printLength(null);
		System.out.println("[프로그램 종료]");
	}

	private static void printLength(String data) {
		// TODO Auto-generated method stub
		try {
			int result = data.length();
			System.out.println("문자 수 : " + result);
		}catch(NullPointerException e) {
			//System.out.println(e.getMessage());
			//System.out.println(e.toString());
			//e.printStackTrace(); <- 생김새가 다 다르긴 함
		}finally {
			System.out.println("[마무리 실행]\n");
		}

	}

}
