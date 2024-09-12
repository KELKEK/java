package com.shinhan.day01;

public class PrintfExample {
	public static void main(String[] args) {
		//\n은 println과 같은 역할 \t <- tab만큼 띄워씀.
		
		f1();
		f2();
			
	}

	private static void f1() {
		// TODO Auto-generated method stub
		int a = 100;
		String b = "자바";
		System.out.printf("a = %d\n", a);
		System.out.printf("b = %s", b);
		
	}
	
	private static void f2()
	{
		int value = 123;
		System.out.printf("상품의 가격:%d원\n", value);
		System.out.printf("상품의 가격:%6d원\n", value);
		System.out.printf("상품의 가격:%-6d원\n", value);
		System.out.printf("상품의 가격:%06d원\n", value);

		double area = 3.14159 * 10 * 10;
		System.out.printf("반지름이 %d인 원의 넓이:%10.2f\n", 10, area);

		String name = "홍길동";
		String job = "도적";
		System.out.printf("%6d |                    %-10s | %10s\n", 1, name, job);//앞자리 혹은 뒷자리를 몇 자리 없앨것인가를 표기함
	}
}	