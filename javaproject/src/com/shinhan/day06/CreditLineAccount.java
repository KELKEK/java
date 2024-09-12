package com.shinhan.day06;

public class CreditLineAccount extends Account {
	int creditLine; //마이너스 한도

	public CreditLineAccount(String accountNo, String ownerName, int balance, int creditLine) {
		super(accountNo, ownerName, balance);
		this.creditLine = creditLine;
	}//source를 이용해 생성자 만들어줌
	
	//인출하는 메서드는 부모의 로직을 사용한다...재정의를 원한다.
	//override : 재정의, 덮어쓰기
	//이름, 매개변수, 타입과 갯수, return이 모두 같아야한다.
	//Modifier는 같거나 더 넓어야한다.
	@Override //오버라이드가 맞는지 확인
	public int withdraw(int amount) {
		if(getBalance() + creditLine < amount) {
			System.out.println("잔고부족. 출금불가");
			return 0;
		}
		setBalance(getBalance() - amount);
		//balance -= amount;
		return amount;
	}//private때문에 접근 못하던 balance를 받아오는 법

	@Override
	public String toString() {
		return "CreditLineAccount [creditLine=" + creditLine + "]"  + super.toString() ;
		//부모의 toString()을 호출 
	}
	
	
}
