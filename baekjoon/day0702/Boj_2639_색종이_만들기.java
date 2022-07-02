package baekjoon.day0702;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2639_색종이_만들기 {

	static int[] color = new int[2];
	static int[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		StringTokenizer st = null;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		go(0, 0, N);
		System.out.println(color[0]);
		System.out.println(color[1]);
		in.close();
	}

	static void go(int r, int c, int n) {
		int curr = board[r][c];
		if (n == 1) {
			color[curr]++;
			return;
		}
		boolean flag = true;
		for (int i = r; i < r + n; i++) {
			for (int j = c; j < c + n; j++) {
				if (board[i][j] != curr) {
					flag = false;
					break;
				}
			}
		}
		if(flag) {
			color[curr]++;
			return;
		}
		go(r, c, n / 2);
		go(r, c + n / 2, n / 2);
		go(r + n / 2, c, n / 2);
		go(r + n / 2, c + n / 2, n / 2);				
		
	}
}
