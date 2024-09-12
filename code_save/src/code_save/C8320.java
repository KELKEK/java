package code_save;

import java.util.Scanner;

public class C8320 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int result = 0;
		
		for(int i = 2; i < n; i++) {
			result += n / i;
		}
		System.out.println(result);
		//아직 덜 풂
	}

}
