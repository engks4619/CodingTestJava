package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14500_테트로미노 {
	
	static int N, M, board[][], result;
	static int[] dr = {1, -1, 0, 0};
	static int[] dc = {0, 0, 1, -1};
	static boolean[][] visited;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		visited = new boolean[N][M];
		result = 0;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				visited[i][j] = true;
				dfs(i, j, 1, board[i][j]);
				visited[i][j] = false;
			}
		}
		System.out.println(result);
		in.close();
	}
	
	static void dfs(int r, int c, int cnt, int sum) {
		if(cnt == 4) {
			result = Math.max(result, sum);
			return;
		}
		for(int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || visited[nr][nc]) continue;
			visited[nr][nc] = true;
			dfs(nr, nc, cnt+1, sum+board[nr][nc]); // 다음좌표
			if(cnt == 2) 
				dfs(r, c, cnt+1, sum+board[nr][nc]); // 현재좌표도 보냄 (ㅗ,ㅓ,ㅏ,ㅜ 모양 처리) 
			visited[nr][nc] = false;
		}
	}
	
}
