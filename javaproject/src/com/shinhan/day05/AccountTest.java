package com.shinhan.day05;

import java.util.Scanner;

public class AccountTest {
	static Scanner sc; // 다른 함수에도 사용 가능, 메인의 Scanner sc = -> sc = 생성만 하면 됨(선언 빠짐)
	// 함수, 메서드 : 문장들의 묶음, 로직 구현, (반복사용시, 모듈화하기 위해)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int sel = 0;
		String address;
		int amount;
		boolean quit = false;
		sc = new Scanner(System.in);
		Account[] arr = new Account[100];
		int index = 0;
		
		while(!quit) {
			show();
			sel = sc.nextInt();
			
			switch(sel) {
			case 1:
				System.out.println("---------------");
				System.out.println(" 계좌생성");
				System.out.println("---------------");
				if(index == arr.length) {
					System.out.println("더이상 계좌생성불가하다.");
				}else {
					createAccount(arr, index++);
					//다음 인덱스값에 다음계좌를 저장할 수 있도록 후위연산자를 씀
				}
				break;		
			case 2:
				System.out.println("---------------");
				System.out.println("계좌목록");
				System.out.println("---------------");
				
				for(Account acc : arr) {
					if(acc == null) {
						break;
					}//더 이상 계좌가 없을 경우 빠져나옴
					else {
						System.out.printf("%10s %10s %10d\n",
								acc.getAddress(), acc.getName(), acc.getBalance());
					}
				}
				break;
			case 3:
				System.out.println("---------------");
				System.out.println("예금");
				System.out.println("---------------");
				System.out.print("계좌번호");
				address = sc.next();
				System.out.print("예금액");
				amount = sc.nextInt();
				for(int i = 0; i < index; i++) {
					if(address.equals(arr[i].getAddress())) {
						arr[i].save(amount);
						break;
					}
				}
				break;
			case 4:
				System.out.println("---------------");
				System.out.println("출금");
				System.out.println("---------------");
				System.out.print("계좌번호");
				address = sc.next();
				System.out.print("출금액");
				amount = sc.nextInt();
				for(int i = 0; i < index; i++) {
					if(address.equals(arr[i].getAddress())) {
						arr[i].withdraw(amount);
						break;
					}
				}
				break;
			case 5:
				quit = true;
				break;
				default :
					System.out.println("1에서 5사이의 값을 입력하세요");
		}
	}
	System.out.println("프로그램 종료");
	sc.close();

	}

	private static void createAccount(Account[] arr, int index) {
		// TODO Auto-generated method stub
		System.out.print("계좌번호");
		String address = sc.next();
		System.out.print("계좌주");
		String name = sc.next();
		System.out.print("초기입금액");
		int balance = sc.nextInt();

		arr[index] = new Account(address, name, balance);

	}

	private static void show() {
		// TODO Auto-generated method stub
		System.out.println("-------------------------------------------------");
		System.out.println("1, 계좌생성 | 2, 계좌목록 | 3, 예금 | 4, 출금 | 5, 종료");
		System.out.println("-------------------------------------------------");
		System.out.print("선택 > ");
	}

}
