package com.shinhan.week3.day1;

import java.util.Comparator;

public class MyDescendingSort implements Comparator<Integer> {// 제네릭을 미리 정해놓는다.
	
	public int compare(Integer o1, Integer o2) {
		return o2 - o1;
	}
//앞-뒤(ASC) 뒤-앞(dESC)
}
