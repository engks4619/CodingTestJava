package swea;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Swea_2382_미생물격리 {

	static int N, M, K ;
	static int[] dr = { 0, -1, 1, 0, 0 };
	static int[] dc = { 0, 0, 0, -1, 1 };
	static Misengmool[][] board;
	
	public static void main(String[] args) throws Exception {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int TC = Integer.parseInt(in.readLine());
		for (int tc = 1; tc <= TC; tc++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			N = Integer.parseInt(st.nextToken());
			M = Integer.parseInt(st.nextToken());
			K = Integer.parseInt(st.nextToken());
			board = new Misengmool[N][N];
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(in.readLine());
				int r = Integer.parseInt(st.nextToken());
				int c = Integer.parseInt(st.nextToken());
				int count = Integer.parseInt(st.nextToken());
				int dir = Integer.parseInt(st.nextToken());
				board[r][c] = new Misengmool(count, dir);
			}
			while(M > 0) {
				move();
				M--;
			}
			int result = 0;
			for(int i = 0; i < N; i++) {
				for(int j = 0; j < N; j++) {
					if(board[i][j] == null) continue;
					result += board[i][j].count;
				}
			}
			sb.append("#").append(tc).append(" ").append(result).append("\n");
		}
		System.out.println(sb);
		in.close();
	}
	
	static void move() {
		// board 원본 배열에서 바뀔 배열
 		Misengmool[][] tempBoard = new Misengmool[N][N]; 
		// 충돌하는 경우에 count가 가장 큰 미생물의 방향으로 정해주기 위해 최대 count와 그 때의 방향 저장할 배열
		Misengmool[][] maxBoard = new Misengmool[N][N]; 
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(board[i][j] != null) {
					Misengmool m = board[i][j];
					int count = m.count;
					int dir = m.dir;
					int nr = i + dr[dir];
					int nc = j + dc[dir];
					if(nr < 0 || nr >= N || nc < 0 || nc >= N) continue; // 범위 넘어가면 넘기기
					if(nr == 0 || nr == N-1 || nc == 0 || nc == N-1) { // 가장자리에 닿으면 count/2, 방향 반대로
						count /= 2;
						switch(dir) {
						case 1: 
							dir = 2;
							break;
						case 2:
							dir = 1;
							break;
						case 3:
							dir = 4;
							break;
						case 4:
							dir = 3;
							break;
						}
					}
					
					if(maxBoard[nr][nc] != null) { // 최대값이 존재한다면
						if(maxBoard[nr][nc].count < count) { // 현재 미생물의 count와 비교하여 현재가 더 크다면
							maxBoard[nr][nc] = new Misengmool(count, dir); // 최대값과 방향 갱신해주기
						}
					}else { // 최대값에 저장이 안되어있으면
						maxBoard[nr][nc] = new Misengmool(count, dir); // 최대값을 현재 미생물로 저장해주기
					}
					
					if(tempBoard[nr][nc] != null) { // 움직일 배열에 이미 값이 존재한다면
						count += tempBoard[nr][nc].count; // count를 더해주기
					}
					
					if(count != 0) { // count가 0이 아니라면
						tempBoard[nr][nc] = new Misengmool(count, maxBoard[nr][nc].dir); // 최종 count와 방향을 설정하여 tempBoard에 넣어주기
					}
				}
			}
		}
		copyBoard(tempBoard); // 원본 board배열을 tempBoard의 값으로 변경해주기
 	}
	
	static class Misengmool {
		int count, dir;

		public Misengmool(int count, int dir) {
			super();
			this.count = count;
			this.dir = dir;
		}
	
	}
	
	static void copyBoard(Misengmool[][] newBoard){
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				board[i][j] = newBoard[i][j];
			}
		}
	}
}
