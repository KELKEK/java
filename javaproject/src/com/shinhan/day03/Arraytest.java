package com.shinhan.day03;

import java.util.Arrays;

public class Arraytest {

	// >java Arraytest
	// JVM이 class load(byte code가 method영역으로 들어간다.)
	// 검증
	// 문제가 없다면 main 시작
	public static void main(String[] args) {//main 매개변수에 배열이 반드시 주어져야 하고 args는 다른 이름으로 바꿀 수 있다.(명령행 매개변수라 한다.)
		System.out.println(args.length + "개");
		//명령형 매개변수 넣기 1, 해당클래스 오른쪽 클릭 2, run->configurations->argument
		//2개 입력받아서 4칙연산 수행하기
		try {
		if(args.length == 2) {
			int su1 = Integer.parseInt(args[0]);
			int su2 = Integer.parseInt(args[1]);
			System.out.println(su1+su2);
			System.out.println(su1-su2);
			System.out.println(su1*su2);
			System.out.println(su1/su2);
			System.out.println(su1%su2);
		}
		}catch(ArrayIndexOutOfBoundsException aa){
			System.out.println("범위가 넘어버림");
			aa.printStackTrace();
		}
		
		System.out.println("끝=============");
		// call();
		// call2();
		// call3();
		//call4();
		// call5();
		// call6();
		// call7();
		//call8();
		//call9();
		method1();
		//method2();
	}

	private static void method2() {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 10, 20, 30 };
		System.out.println("=====향상된 for, 확장 for=========");
		for (int data : arr) {// 왼쪽 : 원소값을 받아올 타입 변수, 오른쪽 : 배열
			System.out.println(data);
		}

		String[] arr2 = { "10살", "20", "30" };
		System.out.println("=====향상된 for, 확장 for=========");
		for (String data : arr2) {// 왼쪽 : 원소값을 받아올 타입 변수, 오른쪽 : 배열
			System.out.println(data);
		}

	}

	private static void method1() {
		// TODO Auto-generated method stub
		int[] arr = new int[] { 10, 20, 30 };
		int[] arr2 = arr; // 주소를 복사
		int[] arr3 = new int[arr.length];
		// arr의 0가 arr3의 0번째로 arr'값' 전체를 복사
		System.arraycopy(arr, 0, arr3, 0, arr.length);
		//System.arraycopy(arr, 0, arr3, 1, arr.length); 이 경우에는 복사하다가 값 범위를 넘어서게 되면서java.lang.ArrayIndexOutOfBoundsException 예외가 나온다.

		arr[0] = 99;
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.toString(arr2));// 따로 값만 받는게 아니라 주소가 복사되어 걍 복제품이 됨
		System.out.println(Arrays.toString(arr3));
	}

	private static void call9() {
		// TODO Auto-generated method stub
		String[][] arr = new String[3][];// 처음에 열들은 NULL이므로 예외당한다.

		for (int i = 0; i < arr.length; i++) {
			arr[i] = new String[] { "자바", "DB" };
			for (int j = 0; j < arr[i].length; j++) {
				System.out.println(arr[i][j]);
			}
		}
	}

	private static void call8() {
		// TODO Auto-generated method stub
		String[] arr = new String[] { "자바", "DB", "WEB", "Framework" };
		String[] arr2 = new String[4]; // null로 초기화된다.

		arr2[0] = "자바";
		arr2[1] = "DB";
		arr2[2] = "WEB";
		arr2[3] = "Framework"; // 처음에 생성해서 new String[4] {.....} 이렇게는 안되더라 설령 수가 맞아도..

		arr[0] += "";// arr[0] = "야호"일 경우는 주소도 다르고 값도 다르다.

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i] + "----" + arr2[i]);// 컴파일 타임 때 같은지 다른지 확인하므로
			System.out.println(arr[i] == arr2[i] ? "주소같다" : "주소다르다");
			System.out.println(arr[i].equals(arr2[i]) ? "값같다" : "값다르다");// 컴파일 타임 때 같은지 다른지 확인하므로
		}
	}

	private static void call7() {
		// TODO Auto-generated method stub
		int[][] score = { { 10, 20, 30, 40 }, { 1, 2, 3 } };
		int total;

		total = 0;

		for (int i = 0; i < score.length; i++) {
			for (int j = 0; j < score[i].length; j++) {
				total += score[i][j];
				System.out.printf("[%d, %d] => %d ", i, j, score[i][j]);
			}
			System.out.println();
		}

		System.out.println("합계점수 : " + total);
	}

	private static void call6() {
		// TODO Auto-generated method stub
		// 2차원 배열 출력
		char[][] arr = { { 'A', 'B', 'C' }, { '가', '나' }, { 'a', 'b', 'c', 'd' } };

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i]); // 값이 그대로 나와버림, 뭉쳐서 나옴(ABC, 가나, abcd)
			System.out.println(Arrays.toString(arr[i])); //[, ]가 첨가됨
			/*for (int j = 0; j < arr[i].length; j++) {
				System.out.print(arr[i][j] + "\t");
			}
			System.out.println();
			*/
		}
	}

	private static void call5() {
		// TODO Auto-generated method stub
		// 2차원 배열
		// 1, 배열 선언
		int[][] arr;
		int[] arr2[];
		int arr3[][]; // 놀랍게도 다 된다 이게 되네
		int[][] arr4 = new int[][] { { 99, 88 }, { 77, 66, 55 } };
		int[][] arr5 = { { 99, 88 }, { 77, 66, 55 } };// 선언과 초기화(생성)을 동시에 함, 따라서 이 때는 new 없어도 됨

		// 2, 배열 생성
		arr = new int[3][4];// 보통은 3행4열 그려서 쓰지만 실제로는 arr[0] 4개를 참조하는 구성
		arr2 = new int[3][]; // 몇 열을 할지는 못정했어
		// arr3 = new int[][];, arr3 = new int[][4]; 이렇게는 안됨
		arr3 = new int[][] { { 10, 20, 30 }, { 40, 50 }, { 60, 70, 80 }, { 90 } };// 배열을 생성하고 초기화까지 같이 함
		
		// 위에 있던것의 연장선인데 new int[][] <- 이녀석은 초기값을 넣을 때 선언+생성일 땐 빼도 상관없지만 분리해서 쓸 경우에는
		// 넣어줘야 함

		// 3, 배열 사용
		System.out.println(arr.length);// 행의 길이
		System.out.println(arr[0].length);// 열의 길이
		// System.out.println(arr[0][1].length); <- 얘는 배열이 아니라 값이 되어버리므로 길이를 구할 수 없다(값에
		// 대한 길이는 구할 수 없다는거).

		System.out.println(arr4[0][1]);
		System.out.println(arr3[2][2]);
		// System.out.println(arr3[3][2]); <- 이건 범위를 벗어난다고 뜨네 4행 3열의 직사각형 개념이 아니게 되나봄
	}

	private static void call4() {
		// TODO Auto-generated method stub
		/*
		 * int[] arr; arr = {10, 20, 30, 40, 50 };// 자동초기화와 달리 자동생성은 안됨
		 */

		int[] arr = { 10, 20, 30, 40, 50 };
		
		int[] arr1;
		arr1 = new int[] {10, 20, 30, 40, 50};

		for (int index = 0; index < arr.length; index++) {// lengrh는 메서드가 아니므로 옆에 length에 () 못 붙임에 주의!!1)
			System.out.println(index + "번째 " + arr[index]);
		}
		
		for (int index = 0; index < arr1.length; index++) {// lengrh는 메서드가 아니므로 옆에 length에 () 못 붙임에 주의!!1)
			System.out.println(index + "번째 " + arr[index]);
		}

	}

	private static void call3() {
		// TODO Auto-generated method stub
		// 배열 선언+생성+초기화
		int[] arr = new int[] { 10, 20, 30, 40, 50 };// new는 변수 선언시점과 값 생성시점이 다를 시에 넣어줌
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call2() {
		// TODO Auto-generated method stub
		int[] arr = new int[10];// 배열 선언+생성
		for (int index = 0; index < arr.length; index++) {
			System.out.println(index + "번째 " + arr[index]);
		}
	}

	private static void call() {
		// TODO Auto-generated method stub
		// 변수 : 하나의 값을 저장하기 위한 기억장소 이름
		// 같은 타입의 값을 여러 개 저장하고자한다. <- 하나의 이름으로 연속 공간을 index로 참조한다. 배열은 힙공간에 저장. 변수는 배열의
		// 첫 공간의 주소를 가리킨다
		// (배열 끼리의 번지 차이는 4byte씩 차이)
		// index는 0부터 시작한다.
		// 1, 배열 선언
		int[] arr1;
		double arr2[];// 둘 다 상관없음
		boolean arr3[];
		char[] arr4;
		String[] arr5;
		// 2, 배열 생성...반드시 배열의 원소 갯수를 알아야 한다.(갯수는 고정만 가능)...값을 부여 안해도 자동으로 초기화된다.
		// 정수 -> 0, 실수 -> 0.0, boolean -> false, char -> ' '(실습할 때는 공백문자가 아니라 네모문자가 나옴,
		// 나는 공백문자나오던데?) , 참조형 -> null
		arr1 = new int[10];
		arr2 = new double[10];
		arr3 = new boolean[10];
		arr4 = new char[10];
		arr5 = new String[10];
		// 3, 배열 사용
		System.out.println(arr1[0]);
		System.out.println(arr2[0]);
		System.out.println(arr3[0]);
		System.out.println("*" + arr4[0] + "*");
		System.out.println(arr5[0]);
	}

}
