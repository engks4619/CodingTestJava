package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14499_주사위굴리기 {
	
	static int x, y, N, M, board[][];
	static int[] dr = { 0, 0, 0, -1, 1 };
	static int[] dc = { 0, 1, -1, 0, 0 };
	static Dice dice;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine(), " ");
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		x = Integer.parseInt(st.nextToken());
		y = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(in.readLine(), " ");
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		dice = new Dice(0,0,0,0,0,0);
		st = new StringTokenizer(in.readLine());
		for (int i = 0; i < K; i++) {
			go(Integer.parseInt(st.nextToken()));
		}
		in.close();
	}

	static void go(int direct) {
		
		int nr = x + dr[direct];
		int nc = y + dc[direct];
		if(nr < 0 || nr >= N || nc < 0 || nc >= M) return;
		int temp;
		switch(direct) {
		case 1:
			temp = dice.left;
			dice.left = dice.top;
			dice.top = dice.right;
			dice.right = dice.down;
			dice.down = temp;
			break;
		case 2:
			temp = dice.right;
			dice.right = dice.top;
			dice.top = dice.left;
			dice.left = dice.down;
			dice.down = temp;
			break;
		case 3:
			temp = dice.front;
			dice.front = dice.top;
			dice.top = dice.back;
			dice.back = dice.down;
			dice.down = temp;
			break;
		case 4:
			temp = dice.back;
			dice.back = dice.top;
			dice.top = dice.front;
			dice.front = dice.down;
			dice.down = temp;
			break;
		}
		x = nr;
		y = nc;
		if(board[x][y] == 0) {
			board[x][y] = dice.down;
		}else {
			dice.down = board[x][y];
			board[x][y] = 0;
		}
		System.out.println(dice.top);
	}

	static class Dice {
		int top, down, left, right, front, back;
		
		public Dice(int top, int down, int left, int right, int front, int back) {
			super();
			this.top = top;
			this.down = down;
			this.left = left;
			this.right = right;
			this.front = front;
			this.back = back;
		}
	}

}
