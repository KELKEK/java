package com.shinhan.day02;

import java.util.Scanner;

public class Lab4_2 {
//alt + 방향키로 줄 순서를 바꿀 수 있다.
//break문은 가장 가까운 반복문을 빠져나간다.
//원하는 반복문을 빼고 싶다면 그 반복문에 이름을 붙이고(라벨링) break옆에 그 이름을 쓴다.(for문에 aa이름을 라벨링 할 떄 :   aa:for~로 표기, break문 시 : break aa;로 표기)
//continue : 이 문구가 나올 시 해당 반복문에 있는 해당 문구 아랫부분을 무시하고 다음 반복으로 넘어감 
//참고로 continue도 break와 같이 라벨링을 해서 원하는 반복문으로 가게할 수 있다. 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method01();
		// method02();
		// method03();
		// method04();
		method05();// 1부터 100 사이의 소수를 찍어보기
	}

	private static void method05() {
		// TODO Auto-generated method stub
		boolean isPrime;
		for(int i = 2; i <= 100; i++) {
			isPrime = true;
			for(int j = 2; j < i; j++) {
				if(i % j == 0) {
					isPrime = false;
				}
			}
				System.out.print(isPrime? i + " ": "");
		}
	}

	private static void method04() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("양의 정수를 입력하세요. : ");
		int num = sc.nextInt();

		int count = 0;
		int sum = 0;

		for (int i = 1; i <= 1000; i++) {
			if (i % num == 0) {
				count++;
				sum += i;
			}
		}

		System.out.printf("%d의 배수 개수 = %d", num, count);
		System.out.printf("%d의 배수 합 = %d", num, sum);
	}

	private static void method03() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요. : ");
		int num = sc.nextInt();
		int result = 1;

		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		}

		for (int i = 1; i <= num; i++) {
			result *= i;
			System.out.printf("%d! = %d\n", i, result);
		}
	}

	private static void method02() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("2 ~ 100 사이의 정수를 입력하세요 : ");
		int num = sc.nextInt();
		int div = 0;

		for (int i = 2; i < num; i++) {
			if (num % i == 0) {
				div++;
			}
		}

		if (div > 0) {
			System.out.printf("%d는(은) 소수가 아닙니다.", num);
		} else {
			System.out.printf("%d는(은) 소수입니다.", num);
		}
	}

	private static void method01() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요 : ");
		int num = sc.nextInt();

		if (num < 2 || num > 9) {
			System.out.println("잘못된 숫자가 입력되었습니다.");
			return;
		} else {
			for (int i = 1; i <= 9; i++) {
				System.out.printf("%d * %d = %d\n", num, i, (num * i));
			}
		}

		sc.close();
	}

}
