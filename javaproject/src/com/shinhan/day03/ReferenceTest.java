package com.shinhan.day03;

import java.util.Arrays;

public class ReferenceTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/*
		call(null);
		call("AAaa");
		System.out.println("프로그램 정상 종료");
		*/
		//call2();
		//call3();
		call4();
	}

	private static void call4() {
		// TODO Auto-generated method stub
		String subject = "이것이 자바다 저자는 신용권,임경균@최재명";
		System.out.println("replace : " + subject.replace("자바", "JAVA"));
		System.out.println("원본은 불변 : " + subject);//원본이 불변하지 않는 이유는 애초에 고정문자열이기 때문(가변 아님)
		System.out.println("indexOf : " + subject.indexOf("자바"));//특정 문자열의 위치를 찾고자 할 때 사용
		System.out.println("indexOf : " + subject.indexOf("자바다"));//특정 문자열의 위치를 찾고자 할 때 사용
		System.out.println("indexOf : " + subject.indexOf(" 자바다"));//특정 문자열의 위치를 찾고자 할 때 사용
		
		
		String[] arr = subject.split(",|@| "); //구분자가 있는 여러 개의 문자열을 분리할 때 split()메소드 사용, 여러 개를 구분자로 삼을 수 있다.
		System.out.println(Arrays.toString(arr));
		
	}

	private static void call3() {
		// TODO Auto-generated method stub
		String subject = "이것이 자바다.";
		System.out.println("length : " + subject.length());
		System.out.println("substring : " + subject.substring(4));//4부터 끝까지
		System.out.println("substring : " + subject.substring(4, 6));//4부터 6까지(4이상 5이하)
		System.out.println("chatAt : " + subject.charAt(0));// 몇 번째 글자?
		
		
		for(int i = 0; i < subject.length(); i++) {
			System.out.println("chatAt : " + subject.charAt(i));
		}
	}

	private static void call2() {
		// TODO Auto-generated method stub
		String s1 = "자바";
		String s2 = "자바";
		String s3 = new String("자바");
		String s4 = new String("자바");
		System.out.println(s1 == s2 ? "주소 같다" : "주소 다르다");//내용을 비교하려면 다르게 해야함
		System.out.println(s3.equals(s4));
		System.out.println(s3 == s4 ? "주소 같다" : "주소 다르다");
		
		//문자 String은 고정문자열이다.
		s1 += "프로그램"; // 주소가 달라진다.
		s2 += "프로그램"; // 주소가 달라진다.
		
		
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		//System.identityHashcode <- 해시코드 확인
		
	}

	private static void call(String s) {
		// TODO Auto-generated method stub
		int a = 10;//지역변수는 반드시 초기화

		// null은 정의된 값이 없다를 의미 <- 지역변수는 반드시 초기화해야 하므로 null을 대신 줌, ""을 쓸 수도 있지만 실제로 String인지 확실히 알 수 없으므로 위험 
		System.out.println("기본형 연습 : " + a);
		System.out.println("참조형 연습 : " + s);
		
		try {
			//exception 발생 가능성이 있는 문장들
			System.out.println("참조형 연습 : " + s.length()); //s값이 null일 시 NullPointerException 예외 발생
		}catch(NullPointerException aa) {
			//예외 발생 시 대처방법을 써놓음
			
			System.out.println(aa.getMessage());//오류문자 출력
		}
		System.out.println("Exception 발생 시 프로그램 중단된다. 복구 가능"); //error와 exception은 다르다.
	}

}
