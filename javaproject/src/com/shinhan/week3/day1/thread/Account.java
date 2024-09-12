package com.shinhan.week3.day1.thread;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
@AllArgsConstructor
@NoArgsConstructor
public class Account {
	String accountNo;
	String ownerName;
	int balance;


	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if (balance >= amount) {
			balance -= amount;
			return amount;
		} else {
			System.out.println("잔고부족");
			return 0;
		}
	}
}

@AllArgsConstructor
class ShareArea {
	Account lee;
	Account sung;

}

class TransferThread extends Thread {

	ShareArea sharearea;

	TransferThread(ShareArea sharearea) {
		this.sharearea = sharearea;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		// 12번 계좌이체
		for (int i = 0; i < 12; i++) {
			synchronized (sharearea) {
				System.out.println("이몽룡계좌에 출금");
				int amount = sharearea.lee.withdraw(100);
				System.out.println("성춘향계좌로 입금");
				sharearea.sung.deposit(amount);
			}

		}
	}

}

class PrintThread implements Runnable {

	ShareArea sharearea;

	PrintThread(ShareArea sharearea) {
		this.sharearea = sharearea;
	}

	@Override
	public void run() {
		synchronized (sharearea) {
			// synchronized block : 공유데이터를 하나의 thread가 점유하고 있을 때 다른 Thread가 접근 불가
			for (int i = 1; i <= 3; i++) {
				int lee = sharearea.lee.balance;
				int sung = sharearea.sung.balance;
				System.out.println(lee + sung);
			}
		}

	}
}
