package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14890_경사로 {
	
	static int N, L, board[][];
	
	public static void main(String[] args) throws Exception{
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		L = Integer.parseInt(st.nextToken());
		board = new int[N][N];
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine());
			for(int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		int count = 0;
		for(int i = 0; i < N; i++) {
			if(checkCol(i)) count++;
			if(checkRow(i)) count++;
		}
		System.out.println(count);
		in.close();
	}
	
	static boolean checkRow(int col) {
		boolean[] isBuilded = new boolean[N];
		for(int i = 0; i < N-1; i++) {
			int diff = board[i][col] - board[i+1][col];
			if(diff==0) continue;
			if(Math.abs(diff) > 1) return false; // 높이 차가 2 이상인 경우 실패
			if(diff == 1) { // 낮아지는 경우
				for(int j = i+1; j <= i + L; j++) {
					// 범위를 벗어 나거나 이미 경사로가 설치되어 있거나 이전과 높이가 다른 경우 실패
					if(j >= N || isBuilded[j] || board[i+1][col] != board[j][col]) return false;
					isBuilded[j] = true;
				} 
			}else if(diff == -1) { // 높아지는 경우
				for(int j = i; j > i - L; j--) {
					if(j < 0 || isBuilded[j] || board[i][col] != board[j][col]) return false;
					isBuilded[j] = true;
				}
			}
		}
		return true;
	}
	
	static boolean checkCol(int row) {
		boolean[] isBuilded = new boolean[N];
		for(int i = 0; i < N-1; i++) {
			int diff = board[row][i] - board[row][i+1];
			if(diff == 0) continue;
			if(Math.abs(diff) > 1) return false; // 높이 차가 2 이상인 경우 실패
			if(diff == 1) { // 낮아지는 경우
				for(int j = i+1; j <= i + L; j++) {
					// 범위를 벗어 나거나 이미 경사로가 설치되어 있거나 이전과 높이가 다른 경우 실패
					if(j >= N || isBuilded[j] || board[row][i+1] != board[row][j]) return false;
					isBuilded[j] = true;
				} 
			}else if(diff == -1) { // 높아지는 경우
				for(int j = i; j > i - L; j--) {
					if(j < 0 || isBuilded[j] || board[row][i] != board[row][j]) return false;
					isBuilded[j] = true;
				}
			}
		}
		return true;
	}
}
