package com.shinhan.week3.day3.prac;

import java.util.Arrays;
import java.util.List;

public class Example {
	public static void main(String[] args) {
		List<String> list = Arrays.asList("This is a java book", "Lambda Expressions",
				"Java8 supports lambda expressions");//바꿀 수 없는 리스트
		list.stream()
		.filter(line-> line.toLowerCase().contains("java"))//나 자신을 소문자로 바꿔버리고 그럴 때 java가 포함되는지 알려준다.
		.forEach(word -> System.out.println(word));
	}
}