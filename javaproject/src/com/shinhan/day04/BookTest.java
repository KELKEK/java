package com.shinhan.day04;

public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 실행 프로그램 ex) 도서관리 프로그램
		//method1();
		method2();

	}

	private static void method2() {
		//Book이 6개 있다.
		Book[] arr = new Book[6];
		arr[0] = new Book("자서전", 0); // heap에 만들어짐
		arr[1] = new Book(); // heap에 만들어짐
		arr[2] = new Book("JavaScript", 30000);
		arr[3] = new Book("HTML, CSS", 20000);
		arr[4] = new Book("SpringFramework");
		arr[5] = new Book(14000);
		
		arr[0].price = 36000;
		arr[1].title = "Oracle";
		arr[1].price = 25000;
		
		for(Book b : arr) {
			b.bookInfoPrint();
		}
	}

	private static void method1() {
		// TODO Auto-generated method stub
		// 1, 객체참조변수 선언
		Book b1, b2, b3, b4, b5, b6;// null로 초기화한다고 객체생성이 된 것은 아님
		// 2, 객체생성
		b1 = new Book("자서전", 0); // heap에 만들어짐
		b2 = new Book(); // heap에 만들어짐
		b3 = new Book("JavaScript", 30000);
		b4 = new Book("HTML, CSS", 20000);
		b5 = new Book("SpringFramework");
		b6 = new Book(14000);
		// 3, 객체사용
		//b1.title = "이것이 자바다";
		b2.title = "Oracle";
		b1.price = 36000;
		b2.price = 25000;
		
		b1.bookInfoPrint();
		b2.bookInfoPrint();
		b3.bookInfoPrint();
		b4.bookInfoPrint();
		b5.bookInfoPrint();
		b6.bookInfoPrint();
		
		
		/*
		System.out.println(b1.title + " : " + b1.price);
		System.out.println(b2.title + " : " + b2.price);
		System.out.println(b3.title + " : " + b3.price);
		System.out.println(b4.title + " : " + b4.price);
		System.out.println(b5.title + " : " + b5.price);
		System.out.println(b6.title + " : " + b6.price);
		*/
		// 주소와 해시코드가 나옴
	}

}
