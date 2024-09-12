package com.shinhan.day04;

public class ParameterTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// static은 static에서만 호출 가능
		// ㄴ 그렇지 않으면 객체를 생성해서 호출해야 한다.
		ParameterTest aa = new ParameterTest();
		aa.sum(10, 20);
		sum(10, 20, 30);

		sum(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
		int[] values = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
		sum(values);
		//밑의 경우에는 new를 꼭 써줘야 한다.
		sum(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10});
		sum("자바", "프로그램");
		sum(3.14, 10.5, 20.2);
	}
	private static void sum(double d, double e, double f) {
		// TODO Auto-generated method stub
		System.out.println("실수3 : " + (d + e + f));
	}
	//ㄴ 정수3개짜리는 없는데 실수 3개짜리가 있다. 근데 정수값 3개의 합을 입력받는 경우
	//ㄴ 위의 실수 3개를 더하는 함수로 간다.
	
	private static void sum(String string, String string2) {
		// TODO Auto-generated method stub
		System.out.println("문자2 : " + string + string2);
	}
	//메서드Overloading : 메서드이름은 같고 매개변수 사양이 다르다.
	private static void sum(int... datas) {// 여러 개의 매개변수 허용
		int total = 0;
		for (int data : datas) {
			total += data;
		}
		
		System.out.println("가변길이 매개변수 : " + total);
	}
/*
	private static void sum(int i, int j, int k) {
		// TODO Auto-generated method stub
		System.out.println("정수합3 : " + (i + j + k));
	}
*/
	// 맴버 메서드(non-static) : 객체 생성 후 호출이 가능
	/* private static */ void sum(int i, int j) {
		// TODO Auto-generated method stub
		System.out.println("정수합2 : " + (i + j));
	}

	void print() {
		sum(1, 2);
		// 여기서는 위의 sum함수 호출 가능

	}

}
