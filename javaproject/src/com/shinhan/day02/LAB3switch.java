package com.shinhan.day02;

import java.util.Scanner;

public class LAB3switch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// printSeason();
		printifSeason();
	}

	private static void printifSeason() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int month = sc.nextInt();
		String message;

		if (month == 3 || month == 4 || month == 5) {
			message = "봄";
		} else if (month == 6 || month == 7 || month == 8) {
			message = "여름";
		} else if (month == 9 || month == 10 || month == 11) {
			message = "가을";
		} else if (month == 12 || month == 1 || month == 2) {
			message = "봄";
		} else {
			sc.close();
			System.out.println("그..안된다!");
		}
	}

	private static void printSeason() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("태어난 월을 입력하세요 : ");
		int num = Integer.parseInt(sc.nextLine());
		String season = "없음";

		switch (num) {
		case 3:// 여기에는 부등호가 들어갈 수 없다.
		case 4:
		case 5:
			season = "봄";
			break;
		case 6:
		case 7:
		case 8:
			season = "여름";
			break;
		case 9:
		case 10:
		case 11:
			season = "가을";
			break;
		case 12:
		case 1:
		case 2:
			season = "겨울";
			break;
		default:
			System.out.println("1~12 사이의 숫자만 입력하셔야 합니다.");
			sc.close();// 메모리 관리를 위해 적어주기
			return; // 함수를 빠지기
		}

		if (!season.equals("없음")) {
			System.out.printf("%s에 태어나셨습니다\n", season);
		}

		sc.close();

	}

}
