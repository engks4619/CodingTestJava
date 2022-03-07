package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1051_숫자_정사각형 {
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int[][] board = new int[N][M];
		int K = N > M ? M : N;
		for(int i = 0; i < N; i++) {
			String data = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = data.charAt(j)-'0';
			}
		}
		int max = 1;
		if(K <= 1) {
			max = K;
		}else {
			for(int size = 2; size <= K; size++) {
				for(int i = 0; i <= N-size; i++) {
					for(int j = 0; j <= M-size; j++) {
						int num = board[i][j];
						if(board[i+size-1][j] == num && board[i][j+size-1] == num && board[i+size-1][j+size-1] == num)
							max = Math.max(max, size*size);
					}
				}
			}
		}
		System.out.println(max);
	}
	
}
