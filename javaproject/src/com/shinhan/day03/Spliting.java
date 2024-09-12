package com.shinhan.day03;

public class Spliting {

	public static void main(String[] args) {
		Spliting p = new Spliting();
		String addr = "서울시,강남구,역삼동,삼성SDS멀티캠퍼스,어딘가";
		String[] addrArr = p.split(addr, ',');
		System.out.println("배열 크기 : " + addrArr.length);
		for (int i = 0; i < addrArr.length; i++) {
			System.out.print(addrArr[i] + " ");
		}
	}

	public String[] split(String str, char separator) {
/*
		String[] result = null;
		int count = 0;
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == separator) {
				count++;
			}
		}

		result = new String[count + 1];// ','가 3개 있으므로 배열은 4개가 만들어져야 함. 단어가 4개가 되니까
		// 여기까지는 단어가 몇 개인지를 찾아 배열의 갯수를 생성한 것.

		int index = 0;
		String word = "";
		for (int i = 0; i < str.length(); i++) {
			if (str.charAt(i) == separator) {
				result[index] = word;
				word = "";
				index++;
			} else {
				word += str.charAt(i);
			}

		}

		result[index] = word; //마지막 단어는 ,를 못 만나기 때문
		return result;
*/
		int idx=0;
		int a =0;
		int arrayCount =1;
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i) == separator)
				arrayCount++;
		}
		
		String arr[] = new String [arrayCount];
		
		for(int i=0;i<str.length();i++) {
			if(str.charAt(i)==separator) {
				arr[a] = str.substring(idx,i);
				idx = i + 1;
				a++;
			}
			if(i == str.length()-1)
				arr[a] = str.substring(idx,++i);
		}
		return arr;
	}
}
