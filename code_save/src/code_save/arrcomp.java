package code_save;

import java.util.Arrays;
import java.util.stream.*;

public class arrcomp {

	public static void main(String[] args) {
		int[] a = {23, 33, 1, 44};
		int sum  = Arrays.stream(a).sum();
		System.out.println(sum);
		Arrays.sort(a);
		for(int k : a) {
			System.out.println(k);
		}
		
		int length = a.length;
	}
	
    int solution(int[] arr1, int[] arr2) {
        int answer = 0;
        return answer;
    }
}
