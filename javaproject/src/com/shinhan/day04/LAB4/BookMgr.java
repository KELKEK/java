package com.shinhan.day04.LAB4;

public class BookMgr {
	Book[] booklist;
	// Book[] booklist = new Book[];//이런 식의 생성은 안됨

	BookMgr(Book[] booklist) {
		this.booklist = booklist;
	}

	void printBookList() {
		System.out.println("========책 목록=========");
		for(Book b : booklist) {
			System.out.println(b.getTitle());
		}
	}

	void printTotalPrice() {
		int total = 0;
		System.out.println("========책 가격의 총합=========");
		for(Book b : booklist) {
			total += b.getPrice();
		}
		System.out.println(total);
	}
}
