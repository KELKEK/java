package com.shinhan.week2.day2.prac;

public interface Machine {
	void powerOn(String title);//인터페이스 내에 메서드가 하나 -> 람다표현식 가능
}

//1. interface 구현 class를 만든다... 만약에 만들어야 하는 경우가 많다면 좋은 방법이 아니다.
//2. 익명구현class를 만든다...필요시마다 만들고 제거된다. <-이쪽이 활용도가 더 높다.
//3. interface 내에 메서드가 하나밖에 없다면 람다표현식을 이용한다.