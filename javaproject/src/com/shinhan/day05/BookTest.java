package com.shinhan.day05;

//다른 패키지에 있는 class를 이용할 경우 반드시 import하고 사용한다.
//java.lang 아래 있는 class는 impor없이 사용 가능 그 이외에는 반드시 import하고 사용


public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method1();
		//method2();
		method3();
	}

	private static void method3() {
		// TODO Auto-generated method stub
		int a = Integer.MAX_VALUE;
		//JAVA가 만든거 잘 써먹자.
		System.out.println(a);
		
		int b = Integer.compare(10, 10);//(앞에게 크면 1, 같으면 0, 작으면 -1)
		System.out.println(b);
		
		System.out.println(Integer.max(40, 22));
		System.out.println(10 < 20? 20 : 10);
	}

	private static void method2() {
		// TODO Auto-generated method stub
		//Book.ISBM = "888880"; <- 상수는 사용불가
		
		Book b1 = new Book();
		//틀리진 않았지만 올바른 사용은 아니다. 왜냐하면 객체 것이 아니라 클래스의 것이기 때문
		System.out.println(b1.ISBM);
		System.out.println(Book.ISBM2);//이런식으로 쓰는게 나음
		
	}

	private static void method1() {
		// TODO Auto-generated method stub
		System.out.println(Book.BookCount);
		
		Book b1 = new Book();
		System.out.println(b1.title);
		System.out.println(b1.price);
		System.out.println(b1.publish);
		System.out.println(b1.publish2);
		System.out.println(b1.publish3);
	}

}
