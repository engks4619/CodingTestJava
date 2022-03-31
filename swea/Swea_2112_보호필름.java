package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Swea_2112_보호필름 {

	static String flagA, flagB;
	static int N, M, K, result;
	static char[][] board, tempBoard;

	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= T; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new char[N][M];
			tempBoard = new char[N][M];
			StringBuilder sbA = new StringBuilder();
			StringBuilder sbB = new StringBuilder();
			for (int i = 0; i < K; i++) {
				sbA.append('0');
				sbB.append('1');
			}
			flagA = sbA.toString();
			flagB = sbB.toString();
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(in.readLine());
				for (int j = 0; j < M; j++) {
					board[i][j] = st.nextToken().charAt(0);
				}
			}
			for(int i = 0; i < N; i++)
				tempBoard[i] = board[i].clone();

			result = N;	
			if(isPass())
				result = 0;
			else 
				dfs(0, 0);							
			
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb.toString());
		in.close();
	}

	static void dfs(int cnt, int idx) {
		if(cnt >= result) return;
		
		if(idx == N) {
			if(isPass()) 
				result = Math.min(result, cnt);			
			return;
		}
		dfs(cnt, idx+1);
		Arrays.fill(tempBoard[idx], '0');
		dfs(cnt+1, idx+1);
		Arrays.fill(tempBoard[idx], '1');
		dfs(cnt+1, idx+1);
		tempBoard[idx] = board[idx].clone();
	}

	static boolean isPass() {
		for (int j = 0; j < M; j++) {
			StringBuilder temp = new StringBuilder();
			for (int i = 0; i < N; i++) 
				temp.append(tempBoard[i][j]);
			
			if (!contains(temp, flagA) && !contains(temp, flagB)) 
				return false;
		}
		return true;
	}

	static boolean contains(StringBuilder sb, String find) {
		return sb.indexOf(find) > -1;
	}
}
