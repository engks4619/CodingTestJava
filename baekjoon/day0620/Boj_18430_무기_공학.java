package baekjoon.day0620;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18430_무기_공학 {

	static int N, M, board[][], answer;
	static boolean[][] visited;
	static int dr[] = { -1, 1, 0, 0 }; // 상 하 좌 우
	static int dc[] = { 0, 0, -1, 1 };

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		answer = Integer.MIN_VALUE;
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		dfs(0, 0, 0);				
		System.out.println(answer);
		in.close();
	}

	static void dfs(int r, int c, int sum) {
		
		if (c == M) { // 오른쪽 범위 넘어가는 경우
			c = 0;
			r++;
		}

		if (r == N) { // 아래 범위 넘어가는 경우
			answer = Math.max(answer, sum);
			return;
		}

		if (!visited[r][c]) {
			int topR = r + dr[0];
			int topC = c + dc[0];
			int downR = r + dr[1];
			int downC = c + dc[1];
			int leftR = r + dr[2];
			int leftC = c + dc[2];
			int rightR = r + dr[3];
			int rightC = c + dc[3];

			if (isInRange(leftR, leftC) && isInRange(downR, downC) && !visited[leftR][leftC]
					&& !visited[downR][downC]) {
				visited[r][c] = true;
				visited[leftR][leftC] = true;
				visited[downR][downC] = true;
				dfs(r, c + 1, sum + 2 * board[r][c] + board[leftR][leftC] + board[downR][downC]);
				visited[r][c] = false;
				visited[leftR][leftC] = false;
				visited[downR][downC] = false;
			}

			if (isInRange(leftR, leftC) && isInRange(topR, topC) && !visited[leftR][leftC] && !visited[topR][topC]) {
				visited[r][c] = true;
				visited[leftR][leftC] = true;
				visited[topR][topC] = true;
				dfs(r, c + 1, sum + 2 * board[r][c] + board[leftR][leftC] + board[topR][topC]);
				visited[r][c] = false;
				visited[leftR][leftC] = false;
				visited[topR][topC] = false;
			}

			if (isInRange(topR, topC) && isInRange(rightR, rightC) && !visited[topR][topC]
					&& !visited[rightR][rightC]) {
				visited[r][c] = true;
				visited[topR][topC] = true;
				visited[rightR][rightC] = true;
				dfs(r, c + 1, sum + 2 * board[r][c] + board[topR][topC] + board[rightR][rightC]);
				visited[r][c] = false;
				visited[topR][topC] = false;
				visited[rightR][rightC] = false;
			}

			if (isInRange(rightR, rightC) && isInRange(downR, downC) && !visited[rightR][rightC]
					&& !visited[downR][downC]) {
				visited[r][c] = true;
				visited[rightR][rightC] = true;
				visited[downR][downC] = true;
				dfs(r, c + 1, sum + 2 * board[r][c] + board[rightR][rightC] + board[downR][downC]);
				visited[r][c] = false;
				visited[rightR][rightC] = false;
				visited[downR][downC] = false;
			}
		}

		dfs(r, c + 1, sum); // 선택안하고 넘어가는 경우
	}

	static boolean isInRange(int r, int c) {
		if (r < 0 || r >= N || c < 0 || c >= M)
			return false;
		return true;
	}

}
