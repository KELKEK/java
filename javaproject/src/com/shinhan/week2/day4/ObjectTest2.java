package com.shinhan.week2.day4;

import java.util.Properties;
import java.util.StringTokenizer;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ObjectTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("1, main 시작");
		//f1(0);
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		//f7();
		f8();
		System.out.println("4, main 끝");
	}

	private static void f8() {
		// TODO Auto-generated method stub
		// 이메일
		String regExp = "[0-9A-Za-z]+@\\w+\\.\\w+";
		String data = "aaaa wed0406@daum.net bbbb zziirr@naver.com";
				
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		//@앞부분만 나오게 하고 싶다.
		String regExp2 = "([0-9A-Za-z]+)@(\\w+\\.\\w+)";
		Pattern patt = Pattern.compile(regExp2);
		Matcher mat = patt.matcher(data);
		while(mat.find()) {
			System.out.println(mat.group());//전체
			System.out.println(mat.group(0));//전체
			System.out.println(mat.group(1));//첫번째()
			System.out.println(mat.group(2));//두번째()
			System.out.println("---------------");
		}
	}
	//.은 임의의 문자 1자
	//\w : [0-9A-Za-z]와 같은 의미
	//+ : 1개 이상
	//* : 0개 이상
	//[] : 선택
	//[-] : 범위
	//[3] : 횟수
	//\\d = [0-9]같은 의미

	private static void f7() {
		// TODO Auto-generated method stub
		//제어문자는 정해져있다. \t \n \"  , \d는 정해져있지 않다. \\->\를 의미
		String regExp = "[01]{3}-[0-9]{3,4}-\\d{4}";//전화번호
		String data = "010-1234-5678";
		
		//data가 regExp의 패턴에 맞았냐를 체크
		boolean result = Pattern.matches(regExp, data);
		System.out.println(result);
		
		String data2 = "짜장면집 111-1234-5678" + " 스시집 010-8488-1247 ";
		Pattern patt = Pattern.compile(regExp);//리턴값으로 패턴이 온다.
		Matcher mat = patt.matcher(data2);
		while(mat.find()) {
			System.out.println(mat.group());
		}//패턴이 맞은 애들만 출력함
		
	}

	private static void f6() {
		//split은 빈값도 사용, StringToken어저고는 빈값무시
		// TODO Auto-generated method stub
		String str = "컴퓨터 커피@지갑, 마이크";
		String arr[] = str.split("@|,| "); //,와 직후 스페이스바(빈값)가 다른 문자열로 취급됨
		for(String s : arr) {
			System.out.println(s);
		}
		System.out.println("---------------------");
		StringTokenizer st = new StringTokenizer(str, "@ | , | "); //토큰끼리 스페이스바로 떨어뜨려도 상관없음
		System.out.println("토큰개수 : " + st.countTokens());
		while(st.hasMoreTokens()) {
			System.out.println(st.nextToken());
		}
	}

	private static void f5() {
		// TODO Auto-generated method stub
		//StringBuilder, StringBuffer는 직접문자열할당 불가
		//StringBuilder s1 = "이것이 자바다";
		StringBuilder s1 = new StringBuilder("이것이 자바다");
		StringBuffer s2 = new StringBuffer("이것이 자바다");
		System.out.println(System.identityHashCode(s1));
		s1.append("!!!!");
		s1.insert(0,  "####");
		System.out.println(s1);//주소는 그대로, 문자열은 append됨
		System.out.println(System.identityHashCode(s1));

	}

	private static void f4() {
		// TODO Auto-generated method stub
		//String은 고정문자열이다.
		String s1 = "이것이 자바다";
		String s2 = new String("이것이 자바다");
		
		byte[] arr = {65, 66, 67, 97, 98, 99};//ABCabc
		String s3 = new String(arr);
		
		char[] arr2 = {'가', '나', '다'};
		String s4 = new String(arr2);
		
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
		System.out.println(s4);
		System.out.println(System.identityHashCode(s4));
		
		s4 += "!!!!!";
		System.out.println(System.identityHashCode(s4));
		//같은 주소에 문자가 추가되는 구조가 아니라 주소가 새로 만들어짐(메모리 낭비 있음(Dangling)
		//잦은 문자열 변경 작업을 해야 한다면 String보다는 StringBuilder가 좋음
	}

	private static void f3() { //System
		// TODO Auto-generated method stub
		//Properties는 Map을 구현함(Key, value)
		//Properties는 키는 Set만들어짐
		//Set<Object>
		//Key가 String이었음 -> Properties로 가면서 Key가 Object됨
		//따라서 Object가 된 Key를 다시 String으로 형변환시킴
		
		System.out.println("java.version");
		
		Properties ps = System.getProperties();
		for(Object key : ps.keySet()) {//keyset <- 키들을 얻어라
			String value = System.getProperty((String) key);
			System.out.println(key + " --> " + value);
		}
	}

	private static void f2() {
		// TODO Auto-generated method stub
		long startTime = System.nanoTime();
		int total = 0;
		for(int i = 1; i < 1000000000; i++) {
			
		}
		long endTime = System.nanoTime();
		System.out.println(endTime - startTime + "ns");
	}

	private static void f1(int j) {
		// TODO Auto-generated method stub
		System.out.println("2, f1시작");
		//if(j == 0) return; //함수를 빠져나가 원래 부른 곳으로 돌아감
		//좋은 방법은 아니라하심 if(j==0) System.exit(0); //일반적으로(관레적으로) 0은 정상종료, -1은 오류를 의미
		try {
			int i = 10/j;
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}//이 흐름이 제일 좋은 방법
		int i = 10/j; //예외발생
		System.out.println("3, f1끝");
	}

}
