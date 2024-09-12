package com.shinhan.week3.day4;

import java.util.Arrays;

public class Review2 {

	public static void main(String[] args) {
		//f1();
		f2();
		//다음 문제는 어제자 prac참고
	}

	private static void f2() {
		int[] arr = {1,2,3,4,5};
//내부반복자
		System.out.println("-------------------forEach는 최종단계");
		Arrays.stream(arr)
		.forEach(s->System.out.println(s));
		System.out.println("-----------------peek는 중간단계, 최종단계가 없으면 출력되지 않음");
		long result = Arrays.stream(arr).peek(i->System.out.println(i)).sum();//sum으로 최종처리해줌으로써 배열출력도 됐다.
		System.out.println("sum : " + result);
	}

	private static void f1() {
		// TODO Auto-generated method stub
		int[] arr = {1,2,3,4,5};
		for(int i : arr) {
			System.out.println(i);
		}//향상for : 외부 반복자(Iterator)이용
	}

}
