package com.shinhan.week2.day3;

import org.json.JSONObject;

import com.firstzone.pack1.Book;
import com.firstzone.pack2.Car;

public class ExternalLIBTest {
	public static void main(String[] args) {
		Book b = new Book("자바다", 50000, "신용권");
		System.out.println(b);//toString을 재정의했으므로 바뀐 재정의 결과대로 출력됨
		
		Car c = new Car("ABC", 2000);
		System.out.println(c);//toString을 저장하지 않아 주소+해시태그 구조가 출력됨
		
		//json : javascript object notation : 자바스크립트객체의 문자열 
		String json = """
				{"name" : "길동", age : 20}
				""";
		
		JSONObject obj = new JSONObject(json);
		System.out.println(obj.get("name"));
		System.out.println(obj.get("age"));
	}
}
