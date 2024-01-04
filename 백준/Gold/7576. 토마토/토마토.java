import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	static int N, M, board[][];
	// 상 하 좌 우
	static int[] dr = {-1,1,0,0};
	static int[] dc = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		List<int[]> tomatoList = new ArrayList<int[]>();
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 1)
					tomatoList.add(new int[] { i, j });
			}
		}
		int time = bfs(tomatoList);
		System.out.println(time);
		in.close();
	}

	static int bfs(List<int[]> tomatoList) {
		Queue<int[]> queue = new ArrayDeque<int[]>();
		for(int[] tomato : tomatoList) {
			queue.offer(new int[] {tomato[0], tomato[1]});
		}
		while(!queue.isEmpty()) {
			for(int i = 0; i < queue.size(); i++) {
				int[] curr = queue.poll();
				int r = curr[0];
				int c = curr[1];
				for(int d = 0; d < dr.length; d++) {
					int nr = r + dr[d];
					int nc = c + dc[d];
					if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] == -1) continue;
					if(board[nr][nc] == 0) {
						board[nr][nc] = board[r][c] + 1;
						queue.offer(new int[] {nr, nc});
					}
				}
			}
		}
		int time = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < M; j++) {
				if(board[i][j] == 0) return -1; // 안익은 토마토가 있는 경우
				time = Math.max(time, board[i][j]);
			}
		}
		return time-1; // 이미 다 익은 경우에도 1-1이므로 0이 반환
	}

}
