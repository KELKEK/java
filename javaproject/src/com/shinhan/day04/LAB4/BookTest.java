package com.shinhan.day04.LAB4;
//이미 다른 패키지에 같은 이름이 있어 충돌을 방지하기 위해 패키지를 새로 만듦
public class BookTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] b = new Book[5];
		b[0] = new Book("Java Program",30000);
		b[1] = new Book("JSP Program",25000);
		b[2] = new Book("SQL Fundamentals",20000);
		b[3] = new Book("JDBC Program",32000);
		b[4] = new Book("EJB Program",25000);
		
		BookMgr bm = new BookMgr(b);
		bm.printBookList();
		bm.printTotalPrice();

	}

}
