package com.shinhan.day04;

import java.util.Arrays;
import java.util.Scanner;

public class ReviewDay3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method1();
		// method2();
		// method3();

		// method5();
		 method6(); //8번 문제도 여기서 풂
		// method7();
		//method8();
	}

	private static void method8() {
		// TODO Auto-generated method stub
		int count = 0;
		boolean isStop = false;
		int std_count = 0;
		int[] scores = null;
		Scanner sc = new Scanner(System.in);

		while (!isStop) {
			menuPrint();// 메뉴를 프린트하는 함수
			System.out.print("선택 > ");
			int ch = sc.nextInt();

			switch (ch) {
			case 1 -> {
				System.out.print("학생 수 > ");
				std_count = sc.nextInt();
			}
			case 2 -> {
				scores = new int[std_count];
				if(std_count <= 0) {
					System.out.println("학생 수가 없습니다.");
					break;
				}
				for(int i = 0; i < scores.length; i++) {
					System.out.printf("scores[%d] > ", i);
					scores[i] = sc.nextInt();
				}
			}
			case 3-> {
				if(std_count <= 0) {
					System.out.println("학생 수가 없습니다.");
					break;
				}
				int i = 0;
				for(int score : scores) {
					System.out.printf("scores[%d] > %d\n", i++, score);
				}
			}
			case 4-> {
				int max = Integer.MIN_VALUE;
				int sum = 0;
				for(int i = 0; i < scores.length; i++) {
					sum += scores[i];
					if(scores[i] > max) {
						max = scores[i];
					}
				}
				
				System.out.printf("최고 점수 : %d\n", max);
				System.out.printf("평균 점수 : %f\n", (float)sum / std_count);
			}
			case 5 -> {
				System.out.println("프로그램 종료");
				isStop = true;
			}

			}

		}
	}

	private static void menuPrint() {
		// TODO Auto-generated method stub
		System.out.println("=====================================");
		System.out.println("1, 학생수 | 2, 점수입력 | 3, 점수리스트 | 4, 분석 | 5, 종료");
		System.out.println("=====================================");

	}

	private static void method7() {
		// TODO Auto-generated method stub
		int[] array = { 1, 5, 3, 8, 2 };
		int max = Integer.MIN_VALUE;// 가변 배열이 주어졌을 경우 어떤 수가 제일 작을 지 모르므로 미리 max를 int값의 최소값으로 초기화해놓는다.
		for (int num : array) {
			if (num > max) {
				max = num;
			}
		}
		System.out.println(max);
	}

	private static void method6() {
		// TODO Auto-generated method stub
		int[][] array = { { 95, 86 }, { 83, 92, 96 }, { 78, 83, 93, 87, 88 } };
		int sum = 0;
		float avg = 0;
		int count = 0;

		for (int[] arr : array) {
			for (int num : arr) {
				sum += num;
				count++;
			}
		}
		avg = (float) sum / count;
		System.out.printf("합 : %d\n", sum);
		System.out.printf("평균 : %.3f", avg);// 소숫점 몇째자리에서 반올림을 찾아보기

	}

	private static void method5() {
		// TODO Auto-generated method stub
		boolean[] arr1 = new boolean[3];
		System.out.println(Arrays.toString(arr1));// false
		Scanner[] arr2 = new Scanner[3];
		System.out.println(Arrays.toString(arr2));// null
	}

	private static void method3() {
		// TODO Auto-generated method stub
		// int a = null;가본형은 null로 초기화 불가

		String s = "자바";
		s += "조아";

		// Integer a = null; 참조타입은 null로 초기화 가능
		int[][] arr = new int[3][4];
		int[][] arr2 = new int[3][];
		int[] arr3[] = new int[3][];
		int arr4[][] = new int[3][4];

		for (int i = 0; i < arr4.length; i++) {
			arr4[i] = new int[i + 2]; // i가 0일 때 2, i = 1일 때 3
			for (int j = 0; j < arr4[i].length; j++) {
				System.out.print(arr4[i][j] + " ");
			}
			System.out.println();
		}
	}

	private static void method2() {
		// TODO Auto-generated method stub
		// 배열 선언 + 생성 + NULL로 자동초기화
		int[] arr = new int[3];
		// 배열 선언 + 생성 + 초기화
		int[] arr2 = new int[] { 1, 10, 100, 1000 };
		int[] arr3 = { 1, 10, 100, 1000 };
		// 1, 배열 선언
		int[] arr4;
		// 2, 선언과 생성을 별개로 할 때는 new를 써줘야 한다.
		arr4 = new int[] { 1, 10, 100, 1000 };

		for (int index = 0; index < arr4.length; index++) {
			System.out.println(arr4[index]);
		}
	}

	private static void method1() {
		// TODO Auto-generated method stub
		// 배열 : 같은 타입의 여러 개의 값을 저장하기 위한 자료구조, heap영역에 연속공간을 만든다.
		// 갯수를 알아야 생성 가능
		// 1, 배열 선언
		int[] arr = null;

		// 2, 배열 생성
		arr = new int[3]; // 자동으로 초기화된다, 꼭 초기화시켜야 배열의 원소 값도 변경시킬 수 있다. 그렇지 않으면 사용이 불가

		// 3, 배열 사용
		arr[0] = 100;
		System.out.println(arr[0]);
	}

}
