package com.shinhan.week3.day1_1;

import lombok.Getter;

@Getter//문제에서 getKey, getValue의 javaBeans기술을 따른다.
public class Container2<A, B> {
	A key;
	B value;
	
	void set(A key, B value) {
		this.key = key;
		this.value = value;
	}
}
