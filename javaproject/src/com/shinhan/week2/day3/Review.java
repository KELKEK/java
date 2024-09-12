package com.shinhan.week2.day3;

//규격서
//@FunctionalInterface <- 람다표현식 표현가능 여부 확인
interface JDBCInterface{
	//1, 상수
	//2, 추상메서드...구현class가 반드시 구현할 의무가 있다.
	/*public abstract*/void connection();
	//3, default method : 구현 가능, 구현class가 공통적으로 사용하는 기능을 넣음, 재정의가 가능하다.
	//4, static method : 구현 가능, 구현class가 공통적으로 사용하는 기능을 넣음, 재정의가 불가능하다.
	//5, private mathod : default메서드에서만 호출이 가능하다.
	//까지만 올 수 있음
}
//구현class 만들기
class OracleDB implements JDBCInterface{
	public void connection() {
		System.out.println("Oracle DB 연결합니다.");
	}
}
class MySQLDB implements JDBCInterface{
	public void connection() {
		System.out.println("MySQL 연결합니다.");
	}
}
//객체 하나 만드려고 클래스를 계속 만드는것은 낭비가 있으므로 익명클래스를 만들어 한 번 쓰고 버리는 것을 만들 수 있다.

public class Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		work(new OracleDB());
		work(new MySQLDB());
		
		work(new JDBCInterface() {
			
			@Override
			public void connection() {
				// TODO Auto-generated method stub
				System.out.println("익명구현class에서 머서드 재정의함");
			}
			void method() {
				System.out.println("메서드 추가함");
			}//method함수는 익명구현class에서만 호출 가능
		});
		work(() -> System.out.println("람다표현식으로 머서드 재정의함"));
		
	}
	
	private static void work(JDBCInterface db) {//인터페이스로 받을 수 있다.
		db.connection();
	}
	
}
