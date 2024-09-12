package com.shinhan.week3.day1;

//<A> : 타입파라메터, 영문자대묹 아무거나
public interface Rentable<P> {
	
	void method1(); // 리턴필수X
	P rent();//리턴이 필요한 함수
	
}
