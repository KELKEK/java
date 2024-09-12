package com.shinhan.day02;

import java.util.Scanner;

public class loopQ {// 챕터 4 연습문제 풀이

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// method07();
		method08();

		// method05();

	}

	private static void method08() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int sel = 0;
		int money = 0;
		boolean isStop = false;

		while (!isStop) {
			menu();

			sel = sc.nextInt();

			switch (sel) {
			case 1:
				System.out.print("예금액 > ");
				int plus = sc.nextInt();// = Integet.parseInt(sc.nextLine());
				money += plus;
				break;
			case 2:
				System.out.print("출금액 > ");
				int minus = sc.nextInt();// 굳이 변수공간을 여러 개 둘 필요 없이 plus와 같은 변수 하나로 쭉 계산해도 상관없다.
				if (money - minus < 0) {
					System.out.println("출금 불가능합니다. 다시 선택해주세요");
					break;
				} else {
					money -= minus;
					break;
				}
			case 3:
				System.out.printf("잔고 > %d\n", money);
				break;
			case 4:
				System.out.println("프로그램 종료");
				isStop = true;// 라벨링을 통해서 무한반복되던 while문을 빠지게 하였다.
				break;
			default:
				break; //switch문 빠져나가기

			}

		}
		sc.close();
		System.out.println("감사합니다 놓고 가신 물건은 없는지 확인해주십시오");
	}

	private static void method05() {
		// TODO Auto-generated method stub
		for (int x = 1; x <= 10; x++) {
			for (int y = 1; y <= 10; y++) {
				if (4 * x + 5 * y == 60) {
					System.out.printf("(%d, %d)\n", x, y);
				}
			}
		}
	}

	private static void method07() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		int sel = 0;
		int money = 0;

		aa: while (true) {
			menu();

			sel = sc.nextInt();

			switch (sel) {
			case 1:
				System.out.print("예금액 > ");
				int plus = sc.nextInt();// = Integet.parseInt(sc.nextLine());
				money += plus;
				break;
			case 2:
				System.out.print("출금액 > ");
				int minus = sc.nextInt();// 굳이 변수공간을 여러 개 둘 필요 없이 plus와 같은 변수 하나로 쭉 계산해도 상관없다.
				if (money - minus < 0) {
					System.out.println("출금 불가능합니다. 다시 선택해주세요");
					break;
				} else {
					money -= minus;
					break;
				}
			case 3:
				System.out.printf("잔고 > %d\n", money);
				break;
			case 4:
				System.out.println("프로그램 종료");
				break aa;// 라벨링을 통해서 무한반복되던 while문을 빠지게 하였다.

			}

		}
		sc.close();
		System.out.println("감사합니다 놓고 가신 물건은 없는지 확인해주십시오");
	}

	private static void menu() {
		// TODO Auto-generated method stub
		System.out.println("--------------------------------");
		System.out.println("1, 예금 | 2, 출금 | 3, 잔고 | 4, 종료");
		System.out.println("--------------------------------");
		System.out.print("선택 > ");
	}

}
