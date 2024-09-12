package com.shinhan.day02;

import java.util.Scanner;

public class LAB4_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method01();//문제 1
		// method02();
		//method03();
		//method04('&', 5, false);
		method05();
		/*Scanner t = new Scanner(System.in);
		int num1 = t.nextInt();
		int num2 = t.nextInt();
		System.out.println(method08(num1, num2));*/
	}

	private static int method08(int a, int b) {
		// TODO Auto-generated method stub
		int result = 1;
		//int comp = a < b ? a : b;
		int comp = Math.min(a, b);
				
		for(int i = 1; i <= comp; i++) {
			if(a % i == 0 && b % i == 0) {
				result = i;
			}
		}
		return result;
	}

	private static void method05() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int num = sc.nextInt();
		
		for(int row = 1; row <= num; row++) {
			for(int col = 1; col <= num + 1 - row; col++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	private static void method04(char cell, int size, boolean isRect) {
		// TODO Auto-generated method stub
		if(isRect) {
			for(int row = 1; row <= size; row++) {
				for(int col = 1; col <= size; col++) {
					System.out.printf("%c", cell);
				}
				System.out.println();
			}
		}else {
			for(int row = 1; row <= size; row++) {
				for(int col = 1; col <= row; col++) {
					System.out.printf("%c", cell);
				}
				System.out.println();
			}
		}
		
		
	}

	private static void method03() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		System.out.print("숫자를 입력하세요. : ");
		int num = sc.nextInt();
		int sum = 0;
		int i;
		
		if (num % 2 == 0) {
			i = 0;
		} else {
			i = 1;
		}
		for (; i <= num; i += 2) {
			sum += i;
		}//조건에 따라서 같은 반복문이 나오면 굳이 중복해서 쓸 필요 없이 밑으로 옮겨놓고 다른 것만 표기하면 좋을듯
		System.out.printf("결과 값 : %d", sum);

	}

	private static void method02() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("문자열을 입력하세요 : ");
		String str = sc.nextLine().toUpperCase();// 대문자로 바꿈

		int length = str.length();

		for (int i = 1; i <= length; i++) {
			System.out.println(str.substring(0, i));// 몇 번째 스트링까지 출력할건지의 원리인가봄. 범위 주의!
		}
	}

	private static void method01() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("초기값을 정수로 입력하세요. : ");
		int init = sc.nextInt();// 초기값
		System.out.print("마지막 값을 정수로 입력하세요. : ");
		int fin = sc.nextInt();// 마지막값
		System.out.print("증가분을 정수로 입력하세요. : ");
		int up = sc.nextInt();// 증가분 입력

		int sum = 0;

		for (; init <= fin; init += up) {
			sum += init;
		}

		if (sum > 1000) {
			sum += 2000;
		}

		System.out.printf("총합은 %d 입니다.\n", sum);
	}

}
