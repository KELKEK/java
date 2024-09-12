package com.shinhan.day01;

import java.util.Scanner;

public class Shinhan {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		minus();
	}

	private static void minus() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("금액의 제한? : ");
		int m = Integer.parseInt(sc.nextLine());
		int n = 0; //금액의 초기값
		
		System.out.print("입출금 횟수 : ");
		int a = Integer.parseInt(sc.nextLine());
		
		int[] ledger = null;
		ledger = new int[a];
		
		for(int i = 0; i < a; i++)
		{
			System.out.print((i + 1) + "번쨰 출금 : ");
			ledger[i] = sc.nextInt();
			if(n + ledger[i] < -m)
			{
				continue;
			}
			else
			{
				n = n + ledger[i];
			}
		}

		System.out.printf("최종 금액 : %d", n);
	}

}
