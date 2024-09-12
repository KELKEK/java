package code_save;

import java.util.Arrays;
import java.util.Scanner;

public class C11399 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		Arrays.sort(arr);
		
		int arrsum = arr[0]; //배열의 합 찾아 배열에 값넣기용
		int result = arr[0];
		
		for(int i = 1; i < N; i++) {
			arrsum += arr[i];
			arr[i] = arrsum;
			result += arr[i];
		}	
		
		System.out.println(result);
	}
}
