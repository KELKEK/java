package com.shinhan.day01;

public class 기본형변수타입 {
	
	public static void main(String[] args) {
		
		String str = "이것이 \n \"자바\"  '자바' 다";
		System.out.println(str);
		/*
		
		String str2 = "aaaaaaaaaaaa"
				+ "bbbbbbbbbbbbbbbbb"
				+ "CCccccccccccccC";
		System.out.println(str2);
		
		
		String str3 = """
				jason타입의 값 저장할 때 유용하다.
				{
					"키" : "값" "키" : "값""키" : "값""키" : "값""키" : "값""키" : "값"
				}
				"""; //17버전 이상일 때 된다.
		System.out.println(str3);
		*/
		f1();
	
		
	}
	
	

	public static void f1() {
		// 변수 :하나의 값을 저장하기 위한 기억장소 이름
		// 변수는 선언 후 사용한다.
		//1, 선언
		byte a; // a변수는 byte값을 담을 수 있다.
		short b;
		char c = 'A';//선언도 하고 할당도 하기 char는 단독문자만 가능
		char d = 65;
		char e = 0x0041;
		int var1 = Integer.MAX_VALUE;
		long var2 = 2147483648L;//java는 우측값부터 읽는데 디폴트가 int이므로 int값을 넘어가서 쓰면 에러라 뜬다. 따라서 long은 뒤에 l(L)을 써준다
		float var3 = 3.14f;//실수의 기본값은 double이으로 double의 값 범위에 맞지 않을 경우 f(F)을 써준다.
		double var4 = 3.14;
		boolean var5 = true;
		boolean var6 = false;// 객체참조형 : 기능을 가진다.
		//Wrapper class : 기본형(8가지) + 기능 <- 클래스가 된 것
		//byte + 기능 = Byte(기능이 첨가되어 맨 앞이 대문자가 됨)
		//short + 기능 = Short
		//char + 기능 = Character
		//int + 기능 = Integer
		//long + 기능 = Long
		//float + 기능 = Float
		//double + 기능 = Double
		//boolean + 기능 = Boolean
		
		int score = 100; // '='은 오른쪽의 값을 왼쪽에 할당한다는 개념, 기본형 : 1, 값을 저장, 연산, 비교만 함
		
		//문자열을 저장하고자 할 때는 JRE시스템 내 String class를 사용한다.)
		//1, 객체참조변수선언
		String str1, str2, str3, str4;
		//2, 객체를 생성한다.
		str1 = new String("자바언어의 문법배우기1");//실행시 생성
		str2 = new String("자바언어의 문법배우기1");//따라서 str1, str2의 주소는 다르다.
		str3 = "자바언어의 문법배우기2"; // 컴파일타임에 저장된다. int, byte 등 기본형변수는 메모리에 값이 저장됨(스택형) 그러나 String과 같은 객체참조형은 다르다(힙형).
		str4 = "자바언어의 문법배우기1"; // 이미 저장된 값을 사용한다.
		
			
		
		//2, 할당(초기화);
		a = 100;
		a++;
		a++;
		b = 32767;
		var1++;
		
		
		//지역변수(메서드 내의 변수)는 반드시 초기화하고 사용한다.
		//System.out.println(a);
		//System.out.println("short 타입값 : " + b);
		//System.out.println("char 타입값 : " + c);
		//System.out.println("char 타입값 : " + d);
		//System.out.println("char 타입값 : " + e);
		//System.out.println("var 타입 최댓값 : " + var1);
		//System.out.println("long 타입값 : " + var2);
		//System.out.println("boolean 타입값 : " + var5);
		//System.out.println("boolean 타입값 : " + var6);
		
		
		System.out.println(System.identityHashCode(str1));
		System.out.println(System.identityHashCode(str2));
		System.out.println(System.identityHashCode(str3));
		System.out.println(System.identityHashCode(str4));
		System.out.println(str1.equals(str4));//'내용'을 비교
		System.out.println(str1 == str2);
		System.out.println(str3 == str4);
	}

}
