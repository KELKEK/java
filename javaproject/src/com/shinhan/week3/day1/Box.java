package com.shinhan.week3.day1;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.ToString;

//제네릭
//실제로는 존재X 임시로 지정함
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Box<T>{
	private T content;

	public T getContent() {
		return content;
	}

	public void setContent(T content) {
		this.content = content;
	}
	
}
