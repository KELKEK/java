package code_save;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int arr[][] = new int[N][N];
		int x = 0;
		int y = 0;
		
		for(int i = 0; i < M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			arr[x][y] = 1;
		}
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				System.out.print(arr[i][j] + ' ');
			}
			System.out.println();
		}
	}
}
