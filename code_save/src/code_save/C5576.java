package code_save;

import java.util.Arrays;
import java.util.Scanner;

public class C5576 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] W = new int[10];
		int[] K = new int[10];
		int sum_W = 0;
		int sum_K = 0;
		for(int i = 0; i < W.length; i++) {
			W[i] = sc.nextInt();
		}
		for(int i = 0; i < K.length; i++) {
			K[i] = sc.nextInt();
		}
		Arrays.sort(W);
		Arrays.sort(K);
		
		for(int i = W.length - 3; i < W.length; i++) {
			sum_W += W[i];
		}
		for(int i = K.length - 3; i < K.length; i++) {
			sum_K += K[i];
		}
		
		System.out.print(sum_W);
		System.out.print(" ");
		System.out.println(sum_K);
	}

}
