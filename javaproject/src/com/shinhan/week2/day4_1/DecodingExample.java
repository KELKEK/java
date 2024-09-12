package com.shinhan.week2.day4_1;

import java.io.UnsupportedEncodingException;

public class DecodingExample {

	public static void main(String[] args) throws UnsupportedEncodingException {
		// TODO Auto-generated method stub
		byte[] bytes = { -20, -107, -120, -21, -123, -107 };
		 String str = new String(bytes, "utf-8");
		 System.out.println("str: " + str);
	}

}
