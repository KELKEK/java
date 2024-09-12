package com.shinhan.day01;


// >javac 연산자연습.java  -> 연산자연습.class
// >java 연산자연습 실행한다.
// 1, 연산자연습.class가 메모리에 올라온다.
// 2, 검증
// 3, main 시작
// 4, main 끝

// 1, stack 영역 -> 지역변수를 저장, 2, heap 영역 -> 객체들의 저장, 3, method 여역 -> static 영역 (static은 static만 부를 수 있음)
public class 연산자연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		//f1();
		//f2();
		//f3();
		f4();
		
	}

	private static void f4() {
		// TODO Auto-generated method stub
		int java = 100;
		int sql = 99;
		int web = 97;
		int count = 3;
		int total = java + sql + web;
		double avg1 = total / 3.0;
		double avg2 = (double)total / count;
		double avg3 = total / (double)count;
		
		double avg4 = (double)(total / 3);//이건 안됨. 애초에 'total / 3'이 int처리 되어버려서 double로 바꿔도 정수가 되어버리기 때문이다.

		System.out.println("총점 : " + total);
		System.out.println("평균 : " + avg1);
		System.out.println("평균 : " + avg2);
		System.out.println("평균 : " + avg3);
		System.out.println("평균 : " + avg4);
		
	}

	private static void f3() {
		// TODO Auto-generated method stub
		int a = 10;
		double b = 20.5f;//자동형변환
		double c = a + b;//자동형변환 (int a가 double 타입으로 바뀜)
		int d = (int)(a + b);//강제형변환
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
		
	}

	private static void f2() {
		// TODO Auto-generated method stub
		float a = 10.5f;
		double b = 20.5f;//자동형변환
		double c = a + b;//자동형변환
		float d = (float)(a + b);//강제형변환
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
		
	}

	private static void f1() {
		// TODO Auto-generated method stub
		byte a = 10;
		byte b = 20;
		byte c = (byte)(a + b);//연산자는 피연산자를 무조건 int로 형변환해버린다.(a, b가 int형이 됨)
		int d = a + b;
		System.out.println(a);
		System.out.println(b);
		System.out.println(c);
		System.out.println(d);
	}

}
