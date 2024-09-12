package com.shinhan.day03;

public class EnumTest {

	
	// 상수 : 변하지 않는 값
	// 하늘이 무너져도 안 바뀜
	final static int SUCCESS = 1;
	final static int FAIL = 0;
	final static int PLAY = 2;
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int score = 100;
		Enum result;
		if(score >= 90) {
			result = Enum.SUCCESS;
		}else {
			result = Enum.FAIL;
		}
		System.out.println(result);
		
		int su = (int)(Math.random() * 7);
		//특정 요일을 뽑고자 할 때의 랜덤은 랜덤함수를 이용하여 풀 수 있다.
		f2();
	}


	private static void f2() {
		// TODO Auto-generated method stub
		Week[] arr = Week.values();
		for(Week week: arr) {
			System.out.println(week + "--" + (week.ordinal() + 1));//ordinary : 순서
		}
		
		call2(Week.FRIDAY);
		call2(Week.SUNDAY);
	}


	private static void call2(Week aa) {
		// TODO Auto-generated method stub
		switch(aa) {
		case FRIDAY :
			System.out.println("오늘은 금요일입니다.");
			break;
		case SATURDAY :
			System.out.println("오늘은 토요일입니다.");
			break;
		case SUNDAY :
			System.out.println("오늘은 일요일입니다.");
			break;
		case MONDAY :
			System.out.println("오늘은 월요일입니다.");
			break;
		case TUESDAY :
			System.out.println("오늘은 화요일입니다.");
			break;
		case WEDNESDAY :
			System.out.println("오늘은 수요일입니다.");
			break;
		case THURSDAY :
			System.out.println("오늘은 목요일입니다.");
			
			//break가 필요없는 표현식으로도 ㄱㄱ
		}
		
		//eunm은 실수를 줄이는 역할을 한다. 타입이 같은 것들 끼리 묶으면 타입에 없는 문자가 나와서 돌아댕기는 것을 막아줄 수 있음
	}
	
	

}
