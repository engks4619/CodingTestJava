package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_12100_2048_Easy {
	
	static int N, result, board[][];
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(in.readLine());
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		result = 0;
		dfs(0, "");
		System.out.println(result);	
		in.close();
	}
	
	static void dfs(int cnt, String s) {		
		if(cnt == 5) {
			int[][] newBoard = copyBoard(board);
			for(int i = 0; i < s.length(); i++) {
				char c = s.charAt(i);
				switch(c) {
				case 'L':
					left(newBoard);
					break;
				case 'R':
					right(newBoard);
					break;
				case 'U':
					up(newBoard);
					break;
				case 'D':
					down(newBoard);
					break;
				}
			}
			result = Math.max(result, getMax(newBoard));
			return;
		}
		dfs(cnt+1, s + "L");
		dfs(cnt+1, s + "R");
		dfs(cnt+1, s + "U");
		dfs(cnt+1, s + "D");
	}
	
	static void left(int[][] board) {
		boolean[][] visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = 1; j < N; j++) {
				if(board[i][j] == 0) continue;
				int idx = j-1;
				while(true) {
					if(idx == 0 || board[i][idx] != 0) break;
					idx--;
				}
				if(board[i][idx] == board[i][j] && !visited[i][idx]) {
					board[i][idx] *= 2;
					board[i][j] = 0;
					visited[i][idx] = true;
				}else if(board[i][idx] == 0) {
					board[i][idx] = board[i][j];
					board[i][j] = 0;
				}else{
					board[i][idx+1] = board[i][j];
					if(j != idx+1) {
						board[i][j] = 0;
					}
				}
			}
		}
	}
	
	static void right(int[][] board) {
		boolean[][] visited = new boolean[N][N];
		for(int i = 0; i < N; i++) {
			for(int j = N-2; j >= 0; j--) {
				if(board[i][j] == 0) continue;
				int idx = j+1;
				while(true) {
					if(idx == N-1 || board[i][idx] != 0) break;
					idx++;
				}
				if(board[i][idx] == board[i][j] && !visited[i][idx]) {
					board[i][idx] *= 2;
					board[i][j] = 0;
					visited[i][idx] = true;
				}else if(board[i][idx] == 0) {
					board[i][idx] = board[i][j];
					board[i][j] = 0;
				}else{
					board[i][idx-1] = board[i][j];
					if(j != idx-1) {
						board[i][j] = 0;
					}
				}
			}
		}
	}
	
	static void up(int[][] board) {
		boolean[][] visited = new boolean[N][N];
		for(int j = 0; j < N; j++) {
			for(int i = 1; i < N; i++) {
				if(board[i][j] == 0) continue;
				int idx = i-1;
				while(true) {
					if(idx == 0 || board[idx][j] != 0) break;
					idx--;
				}
				if(board[idx][j] == board[i][j] && !visited[idx][j]) {
					board[idx][j] *= 2;
					board[i][j] = 0;
					visited[idx][j] = true;
				}else if(board[idx][j] == 0) {
					board[idx][j] = board[i][j];
					board[i][j] = 0;
				}else{
					board[idx+1][j] = board[i][j];
					if(i != idx+1) {
						board[i][j] = 0;
					}
				}
			}
		}
	}
	
	static void down(int[][] board) {
		boolean[][] visited = new boolean[N][N];
		for(int j = 0; j < N; j++) {
			for(int i = N-2; i >= 0; i--) {
				if(board[i][j] == 0) continue;
				int idx = i+1;
				while(true) {
					if(idx == N-1 || board[idx][j] != 0) break;
					idx++;
				}
				if(board[idx][j] == board[i][j] && !visited[idx][j]) {
					board[idx][j] *= 2;
					board[i][j] = 0;
					visited[idx][j] = true;
				}else if(board[idx][j] == 0) {
					board[idx][j] = board[i][j];
					board[i][j] = 0;
				}else{
					board[idx-1][j] = board[i][j];
					if(i != idx-1) {
						board[i][j] = 0;
					}
				}
			}
		}
	}
	
	static int getMax(int[][] board) {
		int max = 0;
		for(int i = 0 ; i < N; i++) {
			for(int j = 0; j < N; j++) {
				max = Math.max(max, board[i][j]);
			}
		}
		return max;
	}
	
	static int[][] copyBoard(int[][] board){
		int[][] newBoard = new int[N][N];
		for(int i = 0; i < N; i++) {
			newBoard[i] = board[i].clone();
		}
		return newBoard;
	}
}
