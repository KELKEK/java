package code_save;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class C2605 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		List<Integer> list = new ArrayList<>();
		
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
		}
		for(int i = 1; i <= N; i++) {
			list.add(arr[i-1], i);
		}
		for(int i = N-1; i >= 0; i--) {
			System.out.print(list.get(i));
			System.out.print(" ");
		}
	}

}
