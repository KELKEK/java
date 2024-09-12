package com.shinhan.week2.day4_1;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.regex.Pattern;

import com.shinhan.week2.day4.ComputerVO;

public class LastTest {
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class a = ComputerVO.class;
		Class b = new ComputerVO().getClass();
		Class c = Class.forName("com.shinhan.week2.day4.ComputerVO");
		
		a.getResource("");
	}

	//^ : 시작
	//$ : 끝
	//[^] : 제외 ex)[^z]
	public static void f5(String[] args) {//17번

		String id = "5Angel1004";
		String regExp = "^[0-9][0-9A-Za-z]{8,12}";
		String regExp2 = "^[0-9]\\w{8,12}z$";
		boolean isMatch = Pattern.matches(regExp, id);
		if (isMatch) {
			System.out.println("ID로 사용할 수 있습니다.");
		} else {
			System.out.println("ID로 사용할 수 없습니다.");
		}
	}



	public static void f4(String[] args) {// 16번
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 E요일 hh시 mm분");
		Date d = new Date();
		System.out.println(sdf.format(d));
	}

	public static void f3(String[] args) {// 15번
		// TODO Auto-generated method stub
		LocalDateTime startDateTime = LocalDateTime.now();

		LocalDateTime endDateTime = LocalDateTime.of(startDateTime.getYear(), 12, 31, 0, 0, 0);
		LocalDateTime newYearTime = LocalDateTime.of(startDateTime.getYear(), 1, 1, 0, 0, 0);

		long remainDay = startDateTime.until(endDateTime, ChronoUnit.DAYS);
		long remainDay2 = newYearTime.until(startDateTime, ChronoUnit.DAYS);
		System.out.println("남은 일자: " + remainDay);
		System.out.println("남은 일자: " + remainDay2);
	}

}
