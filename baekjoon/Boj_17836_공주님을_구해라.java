package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_17836_공주님을_구해라 {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };

	static int N, M, T;
	static boolean gram = false;
	static int result = Integer.MAX_VALUE;
	static int[][] board;
	static boolean[][][] visited;

	static class Point {
		int r, c, count;
		boolean gram;

		public Point(int r, int c, int count, boolean gram) {
			super();
			this.r = r;
			this.c = c;
			this.count = count;
			this.gram = gram;
		}
	}

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M][2];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		boolean flag = bfs(0, 0);
		System.out.println(flag ? result : "Fail");
		in.close();
	}

	static boolean bfs(int r, int c) {
		Queue<Point> queue = new ArrayDeque<>();
		visited[r][c][0] = true;
		queue.offer(new Point(r, c, 0, false)); // r, c, count, gram

		while (!queue.isEmpty()) {
			Point p = queue.poll();
			if(p.count > T) 
				return false;
			
			if (p.r == N - 1 && p.c == M - 1) {
				result = Math.min(result, p.count);
				return true;
			}
			for (int d = 0; d < dr.length; d++) {
				int nr = p.r + dr[d];
				int nc = p.c + dc[d];
				if (nr < 0 || nr >= N || nc < 0 || nc >= M)
					continue;
				if (p.gram) {
					if (!visited[nr][nc][1]) {
						visited[nr][nc][1] = true;
						queue.offer(new Point(nr, nc, p.count + 1, p.gram));
					}
				} else {
					if(!visited[nr][nc][0]) {
						if (board[nr][nc] == 2) {
							visited[nr][nc][1] = true;
							queue.offer(new Point(nr, nc, p.count + 1, true));
						}
						if (board[nr][nc] == 0) {
							visited[nr][nc][0] = true;
							queue.offer(new Point(nr, nc, p.count + 1, p.gram));
						}
					}

				}
			}

		}
		return false;
	}
}
