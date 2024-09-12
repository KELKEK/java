package com.shinhan.day05;

import java.util.Arrays;

public class ShinhanTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] tickets = { 10, 8, 20000 };
		int[][][] requests = {
				{ { 2, 3 }, { 1, 7 }, { 2, 4 }, { 3, 5 } },
				{ { 1, 9 }, { 3, 7 }, { 2, 5 } },
				{ { 3, 1 }, { 2, 5 }, { 2, 10 }, { 3, 8 }, { 1, 2 } } };
		

		
		for (int testcast = 0; testcast < tickets.length; testcast++) {
			//selectionSort(requests[testcast]);
			bubbleSort(requests[testcast]);//버블정렬
			//javaSort(requests[testcast]);//자바의 소트기능
			
			System.out.println("-------------------testcast[" + testcast + "]");
			int result = solution(tickets[testcast], requests[testcast]);
			System.out.println("판매개수 : " + result);//string concat
			
			for (int[] arr : requests[testcast]) {
				System.out.println(Arrays.toString(arr));
			}
		}

	}
	
		private static void javaSort(int[][] requests) {
		// TODO Auto-generated method stub
		/*Integer[] score = {10, 100, 88, 44, 77, 33};
		System.out.println("before : " + Arrays.toString(score));
		Arrays.sort(score, (a, b)-> b - a); //< = > 순으로 default, a - b일 시는 오름차순, 인터페이스 미리배우기
		System.out.println("After : " + Arrays.toString(score));
		*/
			
		Arrays.sort(requests, (a, b) -> {
			if(a[0] == b[0]) return b[1] - a[1]; //이쪽은 티켓 갯수를 구하는 것이므로 내림차순
			return a[0] - b[0];});//관객 레벨 순서이므로 오름차순
	}

		private static void bubbleSort(int[][] requests) {
		// TODO Auto-generated method stub
			for(int i = 0; i < requests.length; i++) {
				for(int j = 0; j < requests.length - i - 1; j++) {
					if(requests[j][0] > requests[j+1][0]){
						//i번째의 1번째 원소와 j번째의 1번쨰 원소 비교
						int[] temp = requests[j];
						requests[j] = requests[j+1];
						requests[j+1] = temp;
					}else if(requests[j][0] == requests[j+1][0] && requests[j][1] < requests[j+1][1]) {
						int[] temp = requests[j];
						requests[j] = requests[j+1];
						requests[j+1] = temp;
					}
				}
			}
	}

		private static void selectionSort(int[][] requests) {
		// TODO Auto-generated method stub
		for(int i = 0;i < requests.length - 1; i++) {
			for(int j = i + 1; j < requests.length; j++) {
				if(requests[i][0] > requests[j][0]){
					//i번째의 1번째 원소와 j번째의 1번쨰 원소 비교
					int[] temp = requests[i];
					requests[i] = requests[j];
					requests[j] = temp;
				}else if(requests[i][0] == requests[j][0] && requests[i][1] < requests[j][1]) {
					int[] temp = requests[i];
					requests[i] = requests[j];
					requests[j] = temp;
				}
			}
		}
	}

		// tickets: 티켓 수
		// requests: 회원 등급, 티켓 구매 수량
		public static int solution(int tickets, int[][] requests) {
	       //이부분 구현
			int result = 0;
			
			for(int[] order : requests) {
				if(tickets >= order[1]) {
					tickets -= order[1];
					result += order[1];
				}
			}
			
			return result;
		}

}
