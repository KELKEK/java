package com.shinhan.week2.day3;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//JavaBeans기술 규격 : field는 private, getter/setter
//DTO(Data Transfer Object) : data를 전송하기 위해
//VO(Value Object) : 값을 저장하기 위해 만듦
@ToString
@Setter
@Getter
@AllArgsConstructor
public class Book {

	private String title;
	private int price;
	private String author;
	
	Book() {
		System.out.println("com.shinhan.week2.day3패키지에 있는 Book");
	}

	@Override
	public String toString() {
		return "Book [title=" + title + ", price=" + price + ", author=" + author + "]";
	}
	
	
}
