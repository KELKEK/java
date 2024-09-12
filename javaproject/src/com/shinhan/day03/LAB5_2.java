package com.shinhan.day03;

public class LAB5_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("문자열에 특정문자 변경하는 테스");
		System.out.println("-------------Sample 1 --------------");
		String str1 = myReplace("hello world", 'l', '*');
		System.out.println(str1);

		System.out.println("-------------Sample 2 --------------");
		String str2 = myReplace("hello world", ' ', '-');
		System.out.println(str2);

		System.out.println("-------------Sample 3 --------------");
		String str3 = myReplace("hello world", 'a', '*');
		System.out.println(str3);

	}

	public static String myReplace(String str, char oldChar, char newChar){
		// 이 부분을 구현하시오.
		char[] arr = str.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == oldChar) {
				//str.charAt(i) = newChar;이게 왼쪽에 저게 못오네
				arr[i] = newChar;
			}
			}
		return new String(arr);//잘 알아두자.
	}
	/*
	 * String newStr =""; for (int i = 0; i < str.length(); i++) { if (str.charAt(i)
	 * == oldChar) { newStr += newChar; } else { newStr += str.charAt(i); } } return
	 * newStr;
	 */
}

