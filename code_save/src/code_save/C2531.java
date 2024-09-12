package code_save;

import java.util.Scanner;

public class C2531 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt(); //회전 초밥 벨트에 놓인 접시 수
		int d = sc.nextInt(); //초밥의 가짓수
		int k = sc.nextInt(); //연속해서 먹는 접시의 수
		int c = sc.nextInt(); //쿠폰번호
		int[] arr = new int[N];
		int[] arr2 = new int[k];
		int check = 0; //쿠폰번호 c가 포함된 배열인지를 확인
		int result; //답 표기용 변수
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			if(arr[i] == c) check++;
		}
		
		if(check > 0) { //쿠폰번호 c가 포함된 배열일 경우
			for(int i = 0; i < N - k + 1; i++) {
				for(int j = 0; j < k; k++) {

				}
			}
		}
		
	}
}

