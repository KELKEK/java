package com.shinhan.day06;


//OOP특징 : 캡슐화(정보은닉, private), 상속(기존class를 물려받음, 수정 및 추가 가능)
// 			다형성(사용은 같지만 결과가 다르다.)
public class InheritenceTest3 {
	public static void main(String[] args) {
		//method1();
		//method2();
		//method3();
		method4();
		//method6();
	}

	private static void method6() {
		// TODO Auto-generated method stub
		// 형변환
		// 1)객체에서 자동형변환 : 부모의 타입방 = 자식의 타입값
		Account acc = new CheckingAccount("113", "양", 2000, "66-77");
		// 2)객체에서 강제형변환 : 자식의 타입방 = (자식의 타입, 반드시 instance의 타입(형제말고 본인))부모의 타입값, 형제로 바꿀 수는 없다!!
		CheckingAccount acc2 = (CheckingAccount) acc;
	}

	private static void method5(Account acc) {//자식은 부모에 담을 수 있다. 자식을 매개변수쪽에 넣게 되면 그 자식만 부를 수 있다.
		// TODO Auto-generated method stub
		// method4의 사용을 5번에서 하고 싶을 때
		// 형변환
		// 1) 자동형변환 : 큰방 = 작은 값
		//long bang;
		//int data = 100;
		//bang = data;
		// 2) 강제(명시)형변환 : 작은방 = (작은방타입)큰 값
		//long data2 = 200;
		//int bang2;
		//bang2 = data2; 오류남
		//bang2 = (int)data2;
		
		System.out.println("---------------------");
		System.out.println(acc);
		System.out.println("계좌번호 : " + acc.getAccountNo());
		System.out.println("예금주 : " + acc.getOwnerName());
		System.out.println("잔고 : " + acc.getBalance());
		
		System.out.println(acc instanceof CheckingAccount);
		//CheckingAccount만 true, 나머지는 전부 false
		
		if(acc instanceof CheckingAccount) {
			//부모 = 자식
			//형제끼리는 캐스팅(변경) 불가
			//자식 = (자식)부모
			CheckingAccount acc2 = (CheckingAccount)acc;
			System.out.println("카드번호 : " + acc2.cardNo);
			acc2.pay("66-77", 100);
		}
		//아래 방식을 사용할 경우 대입연산자 줄 안 써도 되다.
		if(acc instanceof CreditLineAccount acc2) {
			System.out.println("마이너스한도 : " + acc2.creditLine);
			int amount = acc2.withdraw(5000);
			System.out.println("출금액 : " + amount);
		}
		if(acc instanceof BonusPointAccount acc3) {
			acc3.deposit(6000);
			System.out.println("보너스 포인트 : " + acc3.bonusPoint);
		}
	}

	private static void method4() {
		// TODO Auto-generated method stub
		Account acc = new Account("112", "김", 1000);
		CheckingAccount acc2 = new CheckingAccount("113", "양", 2000, "66-77");
		CreditLineAccount acc3 = new CreditLineAccount("114", "박", 3000, 2000);
		BonusPointAccount acc4 = new BonusPointAccount("115", "정", 4000, 4);
		
		

		method5(acc);
		method5(acc2);
		method5(acc3);
		method5(acc4);
		//다형성(toString();)
		//System.out.println(acc.toString());
		//System.out.println(acc2.toString());
		//System.out.println(acc3.toString());
		//System.out.println(acc4.toString());
	}
	
	

	private static void method3() {
		// TODO Auto-generated method stub
		BonusPointAccount acc1 = 
			new BonusPointAccount("1123", "길동", 1000, 1);
		acc1.deposit(5000);
		System.out.println(acc1.getBalance());
		System.out.println(acc1.bonusPoint);
	}

	private static void method2() {
		// TODO Auto-generated method stub
		CreditLineAccount acc2 = new CreditLineAccount("112", "현상", 2000, 1000);
		acc2.deposit(2000);
		int amount = acc2.withdraw(5000);
		System.out.println("출금액 : " + amount);
		System.out.println("잔객 : " +  acc2.getBalance());
	}

	private static void method1() {
		// TODO Auto-generated method stub
		CheckingAccount acc1 = new CheckingAccount("112-234", "홍길동", 1000, "Shcard");
		acc1.deposit(2000);
		int amount = acc1.withdraw(1200);
		//다시 보기
		System.out.println("출금액 : " + amount);
		System.out.println("잔고 : " + acc1.getBalance());
		//출금액과 잔고 출력
		
		amount = acc1.pay("77-88", 800);
		System.out.println(amount);
		amount = acc1.pay("Shcard", 800);
		System.out.println(amount);
	}
	
	Book f1() {
		return new Book("aa", 1000); 
	}
}


class ResultValue{
	boolean a;
	int b;
	String c;
	public ResultValue(boolean a, int b, String c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
}


class Book{
	String title;
	int price;
	Book(String title, int price){
		this.title = title;
		this.price = price;
	}
}