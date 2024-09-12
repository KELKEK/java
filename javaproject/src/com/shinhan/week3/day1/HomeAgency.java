package com.shinhan.week3.day1;

public class HomeAgency implements Rentable<Home>{

	@Override
	public void method1() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Home rent() {
		// TODO Auto-generated method stub
		return new Home();//새 홈 객체를 생성
	}//리턴을 Home으로 한다.

}
