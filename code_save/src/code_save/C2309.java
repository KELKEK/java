package code_save;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class C2309 {
	public static void main(String[] args) throws Exception {
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int[] arr = new int[9];
		int sum = 0;
		int sum_save = 0;
		for(int i = 0; i < arr.length; i++) {
			arr[i] = Integer.parseInt(bf.readLine());
			sum += arr[i];
		}
		sum_save = sum;
		Arrays.sort(arr);
		
		aa:for(int a = 0; a < arr.length - 1; a++) {
			for(int b = a + 1; b < arr.length; b++) {
				sum -= (arr[a] + arr[b]);
				if(sum == 100) {
					for(int c = 0; c < arr.length; c++) {
						if(arr[c] != arr[a] && arr[c] != arr[b]) {
							System.out.println(arr[c]);
						}
					}
					break aa;
				}
				sum = sum_save;
			}
		}
	}
}
