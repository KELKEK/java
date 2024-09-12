package com.shinhan.day04;

public class Account {
	String accNo;
	int balance;

	Account(String accNo, int balance) {
		this.accNo = accNo;
		this.balance = balance;
		System.out.println(accNo + " 계좌가 개설되었습니다.");
		print();
	}

	void deposit(int plus) {
		System.out.println(accNo + " 계좌에 " + plus + "원이 입급되었습니다.");
		// 너무 길 때는 이렇게 나눠써도 괜찮긴 할듯
		balance += plus;
		print();
	}

	void withdraw(int plus) {
		if (balance - plus < 0) {
			System.out.println(accNo + " 계좌에 출금이 불가합니다.");
			return;
		}
		System.out.println(accNo + " 계좌에 " + plus + "원이 출금되었습니다.");
		balance -= plus;
		print();
		return;
	}

	void print() {
		System.out.println(accNo + " 계좌의 잔고는 " + balance + "원입니다.");
	}
}
