package com.shinhan.day03;

import java.util.Scanner;

public class LAB5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//method01();
		
		
		int[][] arr1 = {{30, 30, 30, 30}, {40, 40, 40, 40}, {50, 50, 50, 50}};
		int[][] arr2 = {{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}};
		int[][] c = new int[arr1.length][arr1[0].length];
		sub(arr1, arr2, c);
		prn(c);
		
		//method02
		
		
		
	}



	private static int[][] sub(int[][] ar1, int[][] ar2, int[][] c) {
		// TODO Auto-generated method stub
		
		for(int i = 0; i < ar1.length; i++) {
			for(int j = 0; j < ar1[i].length; j++) {//혹시 배열 구조가 바뀔까봐 미리 ar1[i]로 해둠.
				c[i][j] = ar1[i][j] - ar2[i][j];
			}
		}
		
		return c;
	}
	
	private static void prn(int[][] c) {
		// TODO Auto-generated method stub
		/*
		for(int i = 0; i < c.length; i++) {
			for(int j = 0; j < c[0].length; j++) {
				System.out.print(c[i][j] + " ");
			}
			System.out.println();
		}
		*/
		for(int[] datas : c) {
			for(int su : datas) {
				System.out.printf("%2d ", su);
			}
			System.out.println();
		}
		
	}
	
	private static void method01() {
		// TODO Auto-generated method stub
		int[] arr = {3, 24, 1, 55, 17, 43, 5};
		
		for(int i = 0; i < arr.length-1; i++) {
			for(int j = i + 1; j < arr.length; j++) {//범위 잘 파악해두기. 범위에 따라 순서가 변할 수 있다.
				int temp;
				if(arr[i] > arr[j]) {
					temp = arr[i];
					arr[i] = arr[j];
					arr[j] = temp;
				}
			}
		}//Arrays.sort(arr)라이브러리도 있는 모양
		
		for(int i = 0; i < arr.length; i++) {
			if(i != arr.length - 1) {
				System.out.printf("%d, ", arr[i]);
			}else {
				System.out.printf("%d", arr[i]);
			}
			
		}
		
	}

}
