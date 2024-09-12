package code_save;

import java.util.Arrays;
import java.util.Scanner;

public class C2304{

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int maxh = 0;//기둥의 최대 높이 구하기
		
		Rec[] arr = new Rec[N];
		
		for(int i = 0; i < arr.length; i++) {
			arr[i] = new Rec(sc.nextInt(), sc.nextInt());
			if(arr[i].height > maxh) {
				maxh = arr[i].height;
			}
		}				
		Arrays.sort(arr); //정렬을 통해 청고의 길이를 잴 수 있고 순서대로 비교도 할 수 있다.
		
		int max = 0;
		int maxArea = (arr[N - 1].pos - arr[0].pos + 1) * maxh;//최대면적
		int result = 0; //빠지는 면적
		
		for(int i = 0; i < arr.length; i++) {
			if(arr[i].height == maxh) {
				break;
			}else if(arr[i].height != maxh && arr[i].height > max) {
				max = arr[i].height;
				result += (arr[i+1].pos - arr[i].pos) * (maxh - max);
			}else if(arr[i].height != maxh && arr[i].height <= max){
				result += (arr[i+1].pos - arr[i].pos) * (maxh - max);
			}
		} //순방향 체크
		
		max = 0;
		
		for(int i = arr.length - 1; i >= 0; i--) {
			if(arr[i].height == maxh) {
				
				break;
			}else if(arr[i].height != maxh && arr[i].height > max) {
				max = arr[i].height;
				result += ((arr[i].pos + 1) - (arr[i-1].pos + 1)) * (maxh - max);
			}else if(arr[i].height != maxh && arr[i].height <= max){
				result += ((arr[i].pos + 1) - (arr[i-1].pos + 1)) * (maxh - max);
			}
		} //역방향 체크
		
		System.out.println(maxArea - result);
	}
}

class Rec implements Comparable<Rec>{
	public int pos;
	public int height;
	
	Rec(int pos, int height) {
		this.pos = pos;
		this.height = height;
	}

	public int getPos() {
		return pos; //위치값을 받아내는 getPos함수 필수
	}

	public int compareTo(Rec r) {
		return getPos() - r.getPos();//위치를 기준으로 정렬을 할 것
	}
}