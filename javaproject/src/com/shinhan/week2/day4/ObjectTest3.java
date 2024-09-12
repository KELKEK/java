package com.shinhan.week2.day4;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Calendar;

import com.shinhan.util.DateUtil;

public class ObjectTest3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//f1();
		//f2();
		//f3();
		//f4();
		//f5();
		//f6();
		//f7();
		f8();
	}

	private static void f8() {
		 java.util.Date d =  new java.util.Date();
		 
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd hh:mm:ss");
		 System.out.println(sdf.format(d));
		
		 //문자->일자 
		 String s = "2024-03-22";
		 SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
		 
		 try {
			java.util.Date d2 =sdf2.parse(s);
			java.sql.Date d3 = new java.sql.Date(d2.getTime());
			System.out.println(d2);
			System.out.println(d3);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 System.out.println(DateUtil.getUtilDate(s));
		 System.out.println(DateUtil.getSQLDate(s));
		 
		 
	}

	private static void f7() {
		// TODO Auto-generated method stub
		int a = 1234567890;
		DecimalFormat format = new DecimalFormat("###, ###, ###");
		System.out.println(format.format(a));
	}

	private static void f6() {
		// TODO Auto-generated method stub
		LocalDateTime d = LocalDateTime.now();
		LocalDate d2 = LocalDate.now();
		System.out.println(d);
		System.out.println(d2);
		
		System.out.println(d.getYear());
		System.out.println(d.getMonth());
		System.out.println(d.getDayOfMonth());
		System.out.println(d.getDayOfWeek());
	}

	private static void f5() {
		// TODO Auto-generated method stub
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH) + 1);
		System.out.println(cal.get(Calendar.DATE));
		System.out.println(cal.get(Calendar.DAY_OF_WEEK)); //6이 금요일
		System.out.println(cal.get(Calendar.HOUR));
	}

	private static void f4() {
		// TODO Auto-generated method stub
		Date d1 = new Date();
		java.util.Date d2 = new java.util.Date();
		//같은 명의지만 다른 Date를 쓰고 싶다면 이렇게 풀네임을 써야 한다.
		
		System.out.println(d2);
		System.out.println(1900 + d2.getYear());
		System.out.println(d2.getTime()); //현재시간을 long값으로 받아옴
		
		java.sql.Date d3 = new java.sql.Date(d2.getTime());
		java.sql.Date d4 = new java.sql.Date(2024-1900, 3-1, 22);
		//취소선이 나오면 더 나은방법이 존재한다는 것이니 함 찾아본다.
		
		System.out.println(d3);
		System.out.println(d4);
		
	}

	private static void f3() {
		// TODO Auto-generated method stub
		double a = 5.5;
		
		System.out.println(Math.ceil(a)); //올림
		System.out.println(Math.floor(a));//내림
		System.out.println(Math.round(a));//내림
	}

	private static void f2() {
		// TODO Auto-generated method stub
		String s = "100";
		String s2 = "100.456";
		int b = Integer.parseInt(s);
		double c = Double.parseDouble(s2);
	}

	private static void f1() {
		Integer a = 100; //Auto Boxing
		//= Integer a = new Integer(100); //deprecated
		
		//int b = a.intValue() + 200; //언박싱(UnBoxing)
		int b = a + 200; //똑같은 말임
	}

}
