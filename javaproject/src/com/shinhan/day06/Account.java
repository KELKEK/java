package com.shinhan.day06;

//extends Object생략
//JavaBeans(Beans는 object)기술 규격서 : field는 접근제한자를 private, 외부에서는 getter/setter로 접근한다.
//public final(최종을 의미) class <- 얘를 넣으면 자식을 만들 수 없다.
//final class : 상속불가
//final field : 1회만 할당, 수정불가
//final static field : 상수(1회할당, 선언 시 또는 static block)
//final method : 재정의 불가
public class Account {
	private final String name = "우리은행";
	private final String name2;
	private static final String NAME3 = "우리은행3";
	private static final String NAME4;
	static {
		NAME4 = "NH은행";
	}
	{
		name2 = "신한은행";
	}
	
	private String accountNo;
	private String ownerName;
	private int balance; //접근지정자를 private로 하고 초기화하는 생성자를 준다.
	
	//생성자 : 정의하지 않으면 컴파일러가 default생성자를 만든다.
	//		 정의하면 만들어주지 않는다.
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}//자식의 생성자에서 super();를 못찾으므로 에러남
	//해결법 1, public Account(){}생성자를 넣어준다. 2, 매개변수를 넣어 명시해준다.
	//아래가 해결법
	public Account() {
		// TODO Auto-generated constructor stub
	}//배개변수가 있는 생성자를 만든 후에 다른 클래스 만들 때 이게 없으면 갑자기 에러나서 당황할 수 있다.

	void deposit(int amount) {
		balance += amount;
	}

	int withdraw(int amount) {
		if(balance < amount) {
			System.out.println("잔고부족. 출금불가");
			return 0;
		}
		
		balance -= amount;
		return amount;
	}
	public int getBalance() {
		return balance;
	}
	public void setBalance(int balance) {
		this.balance = balance;
	}

	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	
	@Override
	public String toString() {
		return "Account [accountNo=" + accountNo + ", ownerName=" + ownerName + ", balance=" + balance + "]";
	}
	
	//필드 추가
	protected String title = "protected";
	//메서드 추가
	protected void Print() {
		
		System.out.println("protected 접근제한자 연습");
	}
	//상속받지 않은 경우 : protected는 같은 패키지에만 접근 가능
}
