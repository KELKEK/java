package com.shinhan.day05;
//getter setter 만들기(source에서 만들 수 있음)19, 20번
public class Account {
	private String address;
	private String name;
	private int balance;
	static final int MIN_BALANCE = 0;
	static final int MAX_BALANCE = 1000000;
	


	public Account(String address, String name, int balance) {
		this.address = address;
		this.name = name;
		this.balance = balance;
		System.out.println("결과 : 계좌가 생성되었습니다.");
	}
	
	public void save(int amount) {
		balance += amount;
	}
	public int withdraw(int amount) {
		if(balance >= amount) {
			balance -= amount;
			System.out.println("결과 : 출금이 성공되었습니다.");
		}
		return balance;
	}
	


/*
	public void setBalance(int balance) {
		if(balance < MIN_BALANCE || balance > MAX_BALANCE) {
			return;
		}
		this.balance = balance;
	}
	
19번 문제	*/

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}
	//필드의 class 변수가 private 접근지정자 때문에 직접접근은 못하지만 getter setter를 통해
	//간접 접근할 수 있다.
}
