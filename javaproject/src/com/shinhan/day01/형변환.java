package com.shinhan.day01;

public class 형변환 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//byte < short < int < long < float < double
		//       char
		
		//f1();//함수 호출, 처음에 함수 안 만들면 빨간 줄 뜨는데 커서를 가까이 대서 생성시키게 할 수 있는 창이 뜬다.
		f2();
	}

	private static void f2() {
		// TODO Auto-generated method stub
		
		
		long var1 = 2147483648L;
		int var2 = 100;
		
		var1 = var2; //작은것을 큰 방에 넣으므로 자동 형변환이 가능
		System.out.println("var1 = " + var1);

		var1 = 2147483648L;
		//역으로 하면 강제형변환을 해야한다.
		var2 = (int)var1;
		System.out.println("var2 = " + var2);
		//강제형변환으로 인해 var2의 데이터가 손상될 수 있다.

		
		String str = "100";
		//int i = (int)str;
		//기본형은 casting 하여 형변환한다.
		//객체는 기능(함수, 메서드)으로 형변환한다.
		
		int i = Integer.parseInt(str); //기능으로 형변환
		System.out.println("i = " + i);
	}

	private static void f1() {
		// TODO Auto-generated method stub
		System.out.println("형변환에 대하여~~~");
		// 큰 방 = 작은 값, 값이 작으면 더 큰 방에 넣을 수 있다.
		//**자동 형변환이 된다.
		byte var1 = 100;
		int var2 = var1;
		double var3 = var1;
		System.out.println(var3);
		
		//char ch = var2; //4바이트는 2바이트에 못 들어간다.
		char ch1 = (char)var1;//직접 값을 넣을 때는 괜찮은데 기본 리터럴은 무조건 int로 지정되어서 변수명을 쓰면 안된다. 따라서 (char)을 써서 강제 형변환을 해야한다
		
		char ch2 = '가';
		int i = ch2;
		System.out.println("i = " + i);
	}

}
