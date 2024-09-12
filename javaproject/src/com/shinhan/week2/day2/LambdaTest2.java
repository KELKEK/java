package com.shinhan.week2.day2;
//람다표현식 가능한지 컴파일타임에 체크하기
//추상메서드가 반드시 1개만 가능하다.
@FunctionalInterface
interface Calculable{
	public abstract void calculate(int x, int y);//public abstract생략됨, 매개변수 없고 return이 없는 경우
	//void calculate2(int x, int y); <- 또 있으면 람다표현식 불가
	
}


@FunctionalInterface
interface Calculable2{
	public abstract int calculate(int x, int y);//public abstract생략됨, return이 있는 경우
	//void calculate2(int x, int y); <- 또 있으면 람다표현식 불가
	
}

public class LambdaTest2 {

	public static void main(String[] args) {
		call2(new Calculable2() {

			@Override
			public int calculate(int x, int y) {
				// TODO Auto-generated method stub
				return x+y;
			}
			
		});
		//람다표현식
		call2((x, y) -> x - y);
		call2((x, y) ->
		{
			System.out.println("문장이 여러개이면 {}로 묶은다. return있으면 반드시 return");
			return x-y;
		});
		call2((left, right) -> left > right? left : right);
		call2((left, right) -> Math.max(left, right));
		//static method를 사용하는 경우
		call2(Math::max);
		
		//instance method를 사용하는 경우(708p)

		
	}
	
	private static void call2(Calculable2 cal) {
		// TODO Auto-generated method stub
		int result = cal.calculate(10, 6);
		System.out.println(result);
	}

	public static void call(Calculable cal) {
		call(new Calculable() {
			public void calculate(int x, int y) {
				System.out.println("익명구현class x+y = " + (x+y));
			}

		});//익명구현클래스 {}가 있으면 구현
		
		
		call((int x, int y) -> System.out.println("람다식 x+y = " + (x - y)));
		call((a, b) -> {
			System.out.println("-------------------------");
			System.out.println("람다식 x+y = " + (a * b));
		 	System.out.println("-------------------------");

		});
		
		
	}

}
