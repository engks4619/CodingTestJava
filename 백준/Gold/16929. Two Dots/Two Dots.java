import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int[] dr = { 1, -1, 0, 0 };
	static int[] dc = { 0, 0, 1, -1 };
	static int N, M;
	static char[][] board;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = in.readLine().toCharArray();
		}
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				boolean[][] visited = new boolean[N][M];
				if(dfs(i,j,i,j,visited, 1)) {
					System.out.println("Yes");
					in.close();
					return;
				}
			}
		}
		System.out.println("No");
		in.close();
	}
	
	static boolean dfs(int r, int c, int startR, int startC, boolean[][] visited, int count) {
		visited[r][c] =  true;
		for(int d = 0; d < dr.length; d++) {
			int nr = r + dr[d];
			int nc = c + dc[d];
			if(nr < 0 || nr >= N || nc < 0 || nc >= M || board[nr][nc] != board[r][c]) continue;
			if(!visited[nr][nc]) {
				visited[nr][nc] = true;
				if(dfs(nr,nc,startR,startC,visited,count+1)) return true;
			}else if(count >= 4 && nr == startR && nc == startC) {
				return true;
			}
		}
		return false;
	}

}
