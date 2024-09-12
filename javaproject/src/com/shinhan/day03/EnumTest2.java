package com.shinhan.day03;

import java.util.Calendar;
import java.util.Scanner;

public class EnumTest2 {
	
	final static String SUCCESS = "성공";
	final static String FAIL = "실패";
	final static String FAIK = "이것이 자바다";//전혀 관계없는 변수까지 실수로 불릴 수 있으므로 Enum을 통해 특정 변수만 나올 수 있게 하여 실수를 없앨 수 있다. 
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//loginCheck();
		getWeek();
	}

	private static void getWeek() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();//'객체가 생성된 것'을 얻기
		//System.out.println(cal);
		int yy = cal.get(Calendar.YEAR);
		int mm = cal.get(Calendar.MONTH) + 1;//0~11값이므로 +1해주어야 함
		int ww = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println("년도 : " + yy );
		System.out.println("월 : " + mm );
		System.out.println("주 : " + ww );
		
		
		Week week = null;
		switch(ww) {
		case 1: week = Week.SUNDAY; break;
		case 2: week = Week.MONDAY; break;
		case 3: week = Week.TUESDAY; break;
		case 4: week = Week.WEDNESDAY; break;
		case 5: week = Week.THURSDAY; break;
		case 6: week = Week.FRIDAY; break;
		case 7: week = Week.SATURDAY; break;
		}
		
		System.out.println(week);
	}

	private static void loginCheck() {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("ID PASS >> ");
		
		String id = sc.next();
		String pass = sc.next();
		Enum result;
		
		if(id.equals("firstzone") && pass.equals("1234")) {
			result = Enum.SUCCESS;
		}else {
			result = Enum.FAIL;
		}
		System.out.println(result);
		sc.close();
	}

}
