package com.shinhan.day02;

public class ifTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method01();
		// method02();
		// method03();// switch문
		// method04();//math
		method05();// 회원등급
		//method06();
	}

	private static void method06() {
		// TODO Auto-generated method stub
		//Wrapper class => 기본형 + 기능
		char grade = 'A'; //'a', 'A', 'b', 'B'
		String message;
		
		grade = Character.toLowerCase(grade);//이러면 대문자들이 전부 소문자가 되어 소문자로만 조건문 비교할 수 있게 되어 좋다.
		
		switch(grade)
		{
		case 'a' -> {message = "우수 회원";}
		case 'b' -> {message = "일반 회원";}
		default -> {message = "손님";}
		}//break 없애는 연습 하기
	}

	private static void method05() {
		// TODO Auto-generated method stub
		char grade = 'B';
		String message;

		/*switch (grade) {
		case 'A'://여기에는 부등호가 들어갈 수 없다.
		case 'a':
			message = "우수회원";
			break;
		case 'B':
		case 'b':
			message = "일반회원";
			break;
		default:
			message = "손님";
		}*/
		
		//12버전부터 지원, break를 빼는 방법
		switch(grade){
		case 'A', 'a' -> {
			int point = 100;
			message = "우수회원" + point;
		}
		case 'B', 'b' -> {
			String point = "good";//위의 switch문도 그렇고 A,B케이스에 똑같이 point변수를 넣고 싶다면 중괄호를 쳐야 한다.
			message = "일반회원" + point;
		}
		default -> {
			message = "손님";
		}
		}

		System.out.printf("%s입니다.\n", message);
	}

	private static void method04() {
		// TODO Auto-generated method stub
		// MATH : 수학 공식들을 유용하게 사용하기 위한 기능들이 들어있다.
		double su = Math.random();// 0이상 1미만 값 나옴

		int result = (int) (su * 45) + 1;// 1부터 45까지의 로또번호 뽑기

		System.out.println(su);
		System.out.println(result);
	}

	private static void method03() {
		// TODO Auto-generated method stub
		int score = 76;
		String grade;

		/*
		 * 
		 * case 10: case 9: grade = "A"; break;// break는 switch 빠지기. break가 없으면 무조건 아래로
		 * 흘러간다.
		 */
		switch (score / 10) {
		case 10, 9:// 17버전이라 가능
			grade = "A";
			break;// break는 switch 빠지기. break가 없으면 무조건 아래로 흘러간다.(grade 값이 바뀔 수 있음)
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";// 디폴트 때는 딱히 break가 필요 없음

		}//switch 사용
		System.out.printf("%s학점\n", grade);
	}

	private static void method02() {
		// TODO Auto-generated method stub
		int score = 80;
		String grade;
		if (score >= 90) {
			System.out.println("A학점");// 이 방식보다는 String 변수를 이용하여 변수화 하고 값을 언제든 활용할 수 있게 하는 것이 좋다.
			grade = "A";
		} else if (score >= 80) {
			System.out.println("B학점");
			grade = "B";
		} else if (score >= 70) {
			System.out.println("C학점");
			grade = "C";
		} else if (score >= 60) {
			System.out.println("D학점");
			grade = "D";
		} else {
			System.out.println("F학점");
			grade = "F";
		}

		System.out.printf("%s학점\n", grade);// if 사용

	}

	private static void method01() {
		// TODO Auto-generated method stub
		int score = 100;
		if (score >= 90) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		} // ctrl+shift+f : 줄맞춤, if else문은 줄맞춤 시 else가 if블록 바로 뒤에 온다.

		System.out.println("if끝");
	}

}
