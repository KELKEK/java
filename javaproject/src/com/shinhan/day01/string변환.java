package com.shinhan.day01;

public class string변환 {

	public static void main(String[] args) {//JVM이 이 클래스의 메인메서드를 호출하기 위해 접근권한을 Public으로 한다.
		// TODO Auto-generated method stub
		//f1();
		//f2();
		//f3();
		f4();
	}

	private static void f4() {
		// TODO Auto-generated method stub
		int a = 100;
		{
			int b = 200;
			System.out.println("1. " + (a + b));
		}//이 구문은 무조건 실행한다는 구문
		if(a >= 100)
		{
			int b = 300;
			System.out.println("2. " + (a + b));
		}
		
		System.out.println("3. " + a);
		//System.out.println(a + b);// b는 블록 안에서만 쓸 수 있으므로 컴파일에러
		
	}

	private static void f3() {
		// TODO Auto-generated method stub
		int a = 100;
		String s = String.valueOf(a);
		String s2 = a+"";//숫자랑 문자를 더하면 문자되니까 저걸 이용한건데 좋은 방법은 아님(메모리 낭비의 문제)
		
		System.out.println(s);
		System.out.println(s2);
	}

	private static void f2() {
		// TODO Auto-generated method stub
		String score = "100";
		System.out.println(score + 200); //문자가 된다. 왜냐하면 String에서 '+'는 연결을 의미한다.
		System.out.println(10 - 2 + score);
		
	}

	private static void f1() {
		// TODO Auto-generated method stub
		String score = "100";
		
		byte a = Byte.parseByte(score);
		short b = Short.parseShort(score);
		int c = Integer.parseInt(score);
		long d = Long.parseLong(score);
		float e = Float.parseFloat(score);
		double f = Double.parseDouble(score);
		
		System.out.println(a + b + c + d + e + f);
	}

}
