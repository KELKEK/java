package com.shinhan.week3.day1;

//변수(data)+기능(메서드)
class Machine {
	Machine() {
		super();// Object의 생성자 생성
		System.out.println("Machine 기본생성자");// 이 둘의 순서를 바꾸면 어차피 맨 위는 부모생성자 호출을 무조건 하므로 부모 생성자가 2번 만들어짐.
	}
}

//상속(부모의 private를 제외한 모든 변수+메서드 접근, 수정(오버라이드), 추가(이름같고 매개변수 다름 <- 오버로딩, 나머지는 걍 추가) 가능)
//AutoClosable 찾아보기 : 자동으로 자원을 닫음
class CoffeeMachine extends Machine implements MyInterface, AutoCloseable {

	CoffeeMachine() {
		super();// Machine의 생성자 생성
		System.out.println("CoffeeMachine 기본생성자");
	}

	@Override
	public void method() {
		// TODO Auto-generated method stub
		System.out.println("method1.....구현class가 Interface에서 정의한 추상메서드를 구현");
	}

	@Override
	public void close() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("AutoClosable 인터페이스의 close()메서드 재정의");
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("CoffeeMachine [....]....field가 있다면 이용해서 정보를 문자열로 만들기");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return "Coffee".hashCode();
	}//주소를 비교

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return	"Coffee".equals("Coffee");//무조건 true, return 뒷 내용은 정의하기 나름이다.
	}
	
	

}

//다중상속이 불가능하므로 인터페이스를 통해 변수+기능을 추가한다.
//규격서 : 상수+추상메서드+디폴트+static+private메서드
interface MyInterface {
	public abstract void method();// 원래는 pulbic abstract가 디폴트이기 때문에 주의 : 몇 번 적어주자.
	// 상속받는 클래스는 반드시 재정의 해야한다.

}

public class Review {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (CoffeeMachine coffee1 = new CoffeeMachine(); CoffeeMachine coffee2 = new CoffeeMachine();) {
			coffee1.method();
			coffee2.method();
			System.out.println(coffee1);
			System.out.println(coffee2);
			System.out.println(coffee1 == coffee2);//주소비교
			System.out.println(coffee1.equals(coffee2));//값비교
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
