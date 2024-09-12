package com.shinhan.day03;

import java.util.Scanner;

public class ReviewDay2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// call(100);
		// call2(23);
		//call3(22);

		//연습문제
		//switchExp();
		//three();
		dice(6);
	}

	private static void dice(int want) {
		// TODO Auto-generated method stub
		//4번 문제
		
		Scanner sc = new Scanner(System.in);//ctrl + shift + o누를 시 자동으로 임포트 해주는 구문을 만들어준다.
		
		//무한loop
		while(true) {
			int su1 = (int)(Math.random() * 6) + 1;//1 <= x <= 6
			int su2 = (int)(Math.random() * 6) + 1;
			
			if(su1 + su2 == want) {
				System.out.printf("(%d, %d)", su1, su2);
				break;
			}
		}
		
		System.out.println("============end==============");
	}

	private static void three() {
		// TODO Auto-generated method stub
		// for문을 이용해서 1~100 중에서 3의 배수의 총합을 출력
		int total = 0;
		
		for(int su = 0; su <= 10; su += 3) {
			total += su;
		}
		System.out.println(total);
	}

	private static void switchExp() {
		// TODO Auto-generated method stub
		// switch Expression으로 표현
		/*
		 * String grade = "B"; int score1 = 0; switch (grade) { case "A": score1 = 100;
		 * break; case "B": int result = 100 - 20; score1 = result; break; default:
		 * score1 = 60; }//switch straight
		 */
		String grade = "B";
		int score1 = 0;
		switch (grade) {
		case "A" -> {
			score1 = 100;
		}
		case "B" -> {
			int result = 100 - 20;
			score1 = result;
		}
		default -> {
			score1 = 60;
		}
		}

		System.out.println(score1);
	}

	private static void call5(int a) {
		// TODO Auto-generated method stub
		// 반복분 do while : 1 ~ a까지 합계 구하기
		int total = 0;
		int i = 1;
		do {
			total += i++;
		} while (i <= a);

		System.out.println("do while....합계 : " + total);
	}

	private static void call4(int a) {
		// TODO Auto-generated method stub
		// 반복분 while : 1 ~ a까지 합계 구하기
		int total = 0;// 지역변수는 선언 시 반드시 초기화를 시켜놔야 한다.
		int i = 1;

		while (i <= a) {
			total += i++;
		}
		System.out.println("while....합계 : " + total);
	}

	private static void call3(int a) {
		// TODO Auto-generated method stub
		// 반복분 for : 1 ~ a까지 합계 구하기
		int total = 0;// 지역변수는 선언 시 반드시 초기화를 시켜놔야 한다.

		for (int i = 1; i <= a; i++) {
			total += i;
		}
		System.out.println("for....합계 : " + total);
	}

	private static void call2(int a) {
		// TODO Auto-generated method stub
		// switch문
		// 주의점 : 실수값은 case로 삼을 수 없다.(소숫점 존재 X)
		switch (a % 2) {
		case 0:
			System.out.println(a + " 짝수");
			break;
		case 1:
			System.out.println(a + " 홀수");
		}
	}

	// 재사용을 위해 만들어짐
	private static void call(int a) {
		// TODO Auto-generated method stub
		// 조건문 if
		if (a % 2 == 0) {
			System.out.println(a + " 짝수");
		} else {
			System.out.println(a + " 홀수");
		}
		// 삼항연산자로 줄일 수 있음
	}

}
