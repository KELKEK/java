package com.shinhan.week2.day3_2;

//import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JavaBeans기술 규격 : field는 private, getter/setter
//DTO(Data Transfer Object) : data를 전송하기 위해
//VO(Value Object) : 값을 저장하기 위해 만듦
//@EqualsAndHashCode(of = {"title", "author"})
//@EqualsAndHashCode(exclude = {"price"})//price제외할 때 쓰임
@ToString
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class Book {

	private String title;
	private int price;
	private String author;
	/*
	public Book(String title, int price, String author) {
		this.title = title;
		this.price = price;
		this.author = author;
	}
*/
	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author=" + author + "]";
	}



	@Override
	public boolean equals(Object obj) {
		Book book = (Book)obj;
		return title.equals(book.title);
	}

	//해시코드도 달라야 하므로 equals 뿐만 아니라 hashcode도 만들어준다.
	@Override
	public int hashCode() {
		return title.hashCode();
	}
	
	
}
