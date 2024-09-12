package com.shinhan.day02;

public class loopingTest {

	private static final String method04 = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method01();
		//method02();
		//method03();//do-while문이었는데 무한루프 오류 고치다가 넘어감..
		method04();

	}

	private static void method04() {
		// TODO Auto-generated method stub
		//3행 4열
		for(int row = 1; row <= 3; row++) {
			for(int col = 1;col <= 4; col++) {
				System.out.printf("%d행 %d열\t", row, col);//탭 하나씩 띄어씀
			}
			System.out.println();
		}
	}

	private static void method02() {
		// TODO Auto-generated method stub
		int i = 1;
		while(i <10) {
			System.out.println("while문 연습");
			i++;
		}
	}

	private static void method01() {
		// TODO Auto-generated method stub
		// 1. for문... 조건에 맞는 동안 반복
		int i = 1;
		
		for (; i <= 10; i++) {
			System.out.println(i + " : java 배우기");
		}
		
		System.out.printf("최종 i값 : %d", i);
	}

}
