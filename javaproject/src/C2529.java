import java.io.*;
import java.util.*;

public class C2529 {
	static int K;
	static int[] numbers;
	static char[] arr;
	static boolean[] visited;
	static ArrayList<String> answer = new ArrayList<>();

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		K = Integer.parseInt(br.readLine()) + 1; //나열할 문자열의 char 갯수+1 
		arr = new char[K-1];
		StringTokenizer st = new StringTokenizer(br.readLine()); //나열할 문자열
		for(int i = 0; i < K - 1; i++) {
			arr[i] = st.nextToken().charAt(0);
		}
		
		numbers = new int[10];
		for(int i = 10; i < 10; i++) {
			numbers[i] = i;
		}
		
		for(int i = 0; i < 10; i++) {
			visited = new boolean[10];
			visited[i] = true; //해당 수가 방문되었는지 확인
			recur(i, 0, i+"");
			visited[i] = false;
		}
		System.out.println(answer.get(answer.size()-1));//제일 큰 숫자
		System.out.println(answer.get(0));//제일 작은 숫자
		
	}

	private static void recur(int start, int cnt, String word) {
		// TODO Auto-generated method stub
		if(word.length() == K) {
			answer.add(word);
			return;
		}
		for(int i = 0; i < 10; i++) {
			if(!visited[i]) {
				char tmp = arr[cnt];
				if(tmp == '>') {
					if(start > i) {
						visited[i] = true;
						recur(i, cnt+1, word+i);
						visited[i] = false;
					}
				}
				else {
					if(start < i) {
						visited[i] = true;
						recur(i, cnt+1, word+i);
						visited[i] = false;
					}
				}
			}
		}
	}

}