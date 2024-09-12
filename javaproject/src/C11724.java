import java.util.Scanner;

public class C11724 {
	static int N, M;
	static int arr[][];
	static boolean visit[];
	static int count;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();

		arr = new int[N + 1][N + 1];
		visit = new boolean[N + 1];
		int x = 0;
		int y = 0;

		for (int i = 0; i < M; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			arr[x][y] = 1;
			arr[y][x] = 1;
		}

		for (int i = 1; i <= N; i++) {
			if (!visit[i]) {
				dfs(i);
				count++;
			}
		}

		System.out.println(count);

	}

	private static void dfs(int num) {
		// TODO Auto-generated method stub
		visit[num] = true;
		for (int i = 1; i <= N; i++) {
			if (!visit[i] && arr[num][i] == 1) {
				dfs(i);
			}
		}
	}
}