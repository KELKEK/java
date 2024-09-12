package com.shinhan.week2.day2;

public class LambdaTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//1번 쓰고 버릴 목적
		//1, 익명
		int result = (new Calculator() {

			@Override
			public int sum(int a, int b) {
				// TODO Auto-generated method stub
				System.out.println("익명구현class");
				return a+b+100;
			}
			
		}).sum(1,  2);
		System.out.println(result);
		
		//2, 람다표현식
		Calculator cal = ((a, b) -> {
			System.out.println("람다표현식");
			return a + b + 200;//여러 줄 있으면 return 꼭 써줘야 한다.
		});
		result = cal.sum(10,  20);
		System.out.println(result);

		
	}

}
