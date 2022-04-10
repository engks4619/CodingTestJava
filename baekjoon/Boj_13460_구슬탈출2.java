package baekjoon;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_13460_구슬탈출2 {
	
	static int N, M, count;
	static char[][] board;
	static boolean[][][][] visited;
	static int[] dr = {1, -1, 0, 0}; //남 북 동 서
	static int[] dc = {0, 0, 1, -1};
	
	static class Ball {
		int br, bc, rr, rc, cnt;
		public Ball() {	}

		public Ball(int br, int bc, int rr, int rc, int cnt) {
			this.br = br;
			this.bc = bc;
			this.rr = rr;
			this.rc = rc;
			this.cnt = cnt;
		}
	}
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(in.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		board = new char[N][M];
		count = Integer.MAX_VALUE;
		visited = new boolean[N][M][N][M];
		
		int rr = -1, rc = -1, br = -1, bc = -1;
		for(int i = 0; i < N; i++) {
			String s = in.readLine();
			for(int j = 0; j < M; j++) {
				board[i][j] = s.charAt(j);
				if(board[i][j] == 'R') {
					rr = i;
					rc = j;
					board[i][j] = '.';
				}
				if(board[i][j] == 'B') {
					br = i;
					bc = j;
					board[i][j] = '.';
				}
			}
		}
		System.out.println(bfs(new Ball(br, bc, rr, rc, 0)) ? count : -1);
		in.close();
	}
	
	static boolean bfs(Ball ball) {
		Queue<Ball> queue = new ArrayDeque<>();
		queue.offer(ball);
		visited[ball.br][ball.bc][ball.rr][ball.rc] = true;
		
		while(!queue.isEmpty()) {
			Ball b = queue.poll();
			int br = b.br;
			int bc = b.bc;
			int rr = b.rr;
			int rc = b.rc;
			
			if(b.cnt >= 10) 
				return false;
			
			for(int d = 0; d < dr.length; d++) {
				//파란 공 움직이기
				int bnr = br;
				int bnc = bc;
				while(true) { 
					bnr += dr[d];
					bnc += dc[d];
					if(board[bnr][bnc] == 'O') break; // 구멍이면 그자리에서 멈추기
					if(board[bnr][bnc] == '#') { // 벽이면 한칸 뒤에서 멈추기
						bnr -= dr[d];
						bnc -= dc[d];
						break;
					}
				}
				//빨간 공 움직이기
				int rnr = rr;
				int rnc = rc;
				while(true) {
					rnr += dr[d];
					rnc += dc[d];
					if(board[rnr][rnc] == 'O') break;
					if(board[rnr][rnc] == '#') {
						rnr -= dr[d];
						rnc -= dc[d];
						break;
					}
				}
				if(board[bnr][bnc] == 'O') continue; // 파란공이 구멍에 빠진 상태면 넘기기
				
				if(board[rnr][rnc] == 'O') { // 빨간공만 구멍에 빠진 경우
					count = b.cnt+1;
					return true;
				}
				if(bnr == rnr && bnc == rnc) { // 움직인 빨간 공과 파란 공의 위치가 같은 경우
					switch(d) { // 방향에 따라 조정 하기
					case 0: // 남
						if(rr > br) 
							bnr -= 1;
						else
							rnr -= 1;
						break;
					case 1: // 북
						if(rr > br)
							rnr += 1;
						else
							bnr += 1;
						break;
					case 2: // 동
						if(rc > bc)
							bnc -= 1;
						else
							rnc -= 1;
						break;
					case 3: // 서
						if(rc > bc)
							rnc += 1;
						else
							bnc += 1;
						break;
					}
				}
				if(!visited[bnr][bnc][rnr][rnc]) {
					visited[bnr][bnc][rnr][rnc] = true;
					queue.offer(new Ball(bnr, bnc, rnr, rnc, b.cnt+1));
				}
			}
			
		}
		return false;
	}


	

}
